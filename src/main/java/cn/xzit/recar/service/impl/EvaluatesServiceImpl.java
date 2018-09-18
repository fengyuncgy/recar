package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.EvaluatesJpa;
import cn.xzit.recar.Jpa.OrderStatusJpa;
import cn.xzit.recar.Jpa.OrdersJpa;
import cn.xzit.recar.Jpa.SalaryJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EvaluatesDto;
import cn.xzit.recar.bean.entity.EvaluatesEntity;
import cn.xzit.recar.bean.entity.OrderStatusEntity;
import cn.xzit.recar.bean.entity.OrdersEntity;
import cn.xzit.recar.bean.entity.SalaryEntity;
import cn.xzit.recar.service.EvaluatesService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class EvaluatesServiceImpl extends CommonService implements EvaluatesService {

    @Autowired
    private EvaluatesJpa evaluatesJpa;

    @Autowired
    private SalaryJpa salaryJpa;


    @Autowired
    private OrdersJpa ordersJpa;

    @Autowired
    private OrderStatusJpa orderStatusJpa;
    @Override
    public List<EvaluatesDto> findAll() {
        return evaluatesJpa.findAllDto();
    }

    @Override
    public CePage<EvaluatesDto> list(Pageable pageable) {
        return page(evaluatesJpa.findAllDto(pageable),pageable,evaluatesJpa.count());
    }

    @Override
    public EvaluatesDto findOne(int id) {
        return evaluatesJpa.findOne(id);
    }

    @Override
    @Transactional
    public boolean addEvaluate(EvaluatesEntity evaluatesEntity) {
        evaluatesJpa.save(evaluatesEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateEvaluate(EvaluatesEntity evaluatesEntity) {
        EvaluatesEntity one = evaluatesJpa.getOne(evaluatesEntity.getEvaluateid());
        if(one.getStatus()==1)return false;
        one.setMaintenance(evaluatesEntity.getMaintenance());
        one.setServer(evaluatesEntity.getServer());
        one.setValue(evaluatesEntity.getValue());
        one.setStatus(1);
        SalaryEntity salaryJpaOne = salaryJpa.getOne(one.getEmployeeid());
        if(one.getMaintenance()==25){
            salaryJpaOne.setMonthCount(salaryJpaOne.getMonthCount()-0.5);
            salaryJpaOne.setFinishCount(salaryJpaOne.getFinishCount()-0.5);
        }else if(one.getMaintenance()==75){
            salaryJpaOne.setMonthCount(salaryJpaOne.getMonthCount()+0.1);
            salaryJpaOne.setFinishCount(salaryJpaOne.getFinishCount()+0.1);
        }else if(one.getMaintenance()==100){
            salaryJpaOne.setMonthCount(salaryJpaOne.getMonthCount()+0.3);
            salaryJpaOne.setFinishCount(salaryJpaOne.getFinishCount()+0.3);
        }
        salaryJpaOne.setAddSalary(salaryJpaOne.getBaseSalary()*salaryJpaOne.getAddProportion()*salaryJpaOne.getMonthCount());

        OrdersEntity ordersByEvaluateid = one.getOrdersByEvaluateid();
        ordersByEvaluateid.setEndTime(TimeUtil.nowTime());
        Collection<OrderStatusEntity> orderStatusesByOrderid = ordersByEvaluateid.getOrderStatusesByOrderid();
        for(OrderStatusEntity orderStatusEntity :orderStatusesByOrderid){
            if(orderStatusEntity.getType()>=4) return false;
            if(orderStatusEntity.getType()==3) {
                orderStatusEntity.setStatusEndTime(TimeUtil.nowTime());
            }
        }
        OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
        orderStatusEntity.setType(4);
        orderStatusEntity.setStatusStartTime(TimeUtil.nowTime());
        orderStatusEntity.setStatusEndTime(TimeUtil.nowTime());
        orderStatusEntity.setOrderid(ordersByEvaluateid.getOrderid());
        orderStatusEntity.setMessage("完成状态");
        Integer id = orderStatusJpa.maxId();
        if(id==null && id>=0) id = 0;
        orderStatusEntity.setOrderStatusid(++id);
        orderStatusesByOrderid.add(orderStatusEntity);
        ordersByEvaluateid.setChangetime(orderStatusEntity.getStatusStartTime());
        ordersByEvaluateid.setEndTime(orderStatusEntity.getStatusEndTime());
        ordersJpa.save(ordersByEvaluateid);
        salaryJpa.save(salaryJpaOne);
        evaluatesJpa.save(one);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteEvaluate(List<Integer> ids) {
        List<EvaluatesEntity> evaluatesEntities = new ArrayList<>();
        ids.forEach(id->{
            EvaluatesEntity evaluatesEntity = new EvaluatesEntity();
            evaluatesEntity.setEvaluateid(id);
            evaluatesEntities.add(evaluatesEntity);
        });
        evaluatesJpa.deleteAll(evaluatesEntities);

        return true;
    }

    @Override
    public List<EvaluatesDto> findByEvaluateid(int id) {
        return evaluatesJpa.findByEvaluateid(id);
    }

    @Override
    public List<EvaluatesDto> findByCarid(List<Integer> id) {
        return evaluatesJpa.findByCarid(id);
    }
}
