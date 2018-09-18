package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.*;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancesDto;
import cn.xzit.recar.bean.entity.*;
import cn.xzit.recar.service.MaintenancesService;
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
public class MaintenancesServiceImpl extends CommonService implements MaintenancesService {

    @Autowired
    private MaintenancesJpa maintenancesJpa;

    @Autowired
    private OrdersJpa ordersJpa;

    @Autowired
    private MaintenancePartJpa maintenancePartJpa;

    @Autowired
    private WarehouseJpa warehouseJpa;

    @Autowired
    private OrderStatusJpa orderStatusJpa;

    @Autowired
    private EvaluatesJpa evaluatesJpa;
    @Autowired
    private SalaryJpa salaryJpa;
    @Override
    @Transactional
    public boolean addMaintenance(MaintenancesEntity maintenancesEntity) {

        Integer id = maintenancesJpa.maxId();
        if (isNull(id)) id = 0;
        maintenancesEntity.setMaintenanceid(++id);
        id = maintenancePartJpa.maxId();
        if (isNull(id)) id = 0;
        Collection<MaintenancePartEntity> maintenancePartsByMaintenanceid = maintenancesEntity.getMaintenancePartsByMaintenanceid();
        for (MaintenancePartEntity maintenancePartEntity : maintenancePartsByMaintenanceid) {
            maintenancePartEntity.setMaintenancePartid(++id);
            int num = - maintenancePartEntity.getNum();
            WarehouseEntity one = warehouseJpa.getOne(maintenancePartEntity.getPartid());
            if(maintenancePartEntity.getNum() > one.getNum()) return false;
            warehouseJpa.updateNum(maintenancePartEntity.getPartid(),num);
        }

        maintenancesJpa.save(maintenancesEntity);
        return true;
    }

    @Override
    public boolean updateEmployeeid(MaintenancesEntity maintenancesEntity) {
        MaintenancesEntity one = maintenancesJpa.getOne(maintenancesEntity.getMaintenanceid());
        one.setEmployeeid(maintenancesEntity.getEmployeeid());
        maintenancesJpa.save(one);
        return true;
    }

    @Override
    public boolean updateStatus(MaintenancesEntity maintenancesEntity) {
        MaintenancesEntity one = maintenancesJpa.getOne(maintenancesEntity.getMaintenanceid());
        one.setMaintenanceHour(maintenancesEntity.getMaintenanceHour());
        if(maintenancesEntity.getMaintenanceStatus()==1){
            one.setMaintenanceStatus(1);
            one.setMaintenanceTime(TimeUtil.nowTime());
        }else if(maintenancesEntity.getMaintenanceStatus()==3){
            OrdersEntity orders = ordersJpa.findOrders(one.getCarid());
            Collection<OrderStatusEntity> orderStatusesByOrderid = orders.getOrderStatusesByOrderid();
            for(OrderStatusEntity orderStatusEntity :orderStatusesByOrderid){
                if(orderStatusEntity.getType()>= 3) return false;
                if(orderStatusEntity.getType()==2) {
                    orderStatusEntity.setStatusEndTime(TimeUtil.nowTime());
                }
            }
            OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
            orderStatusEntity.setType(3);
            orderStatusEntity.setStatusStartTime(TimeUtil.nowTime());
            orderStatusEntity.setOrderid(orders.getOrderid());
            orderStatusEntity.setMessage("评价状态");
            Integer id = orderStatusJpa.maxId();
            if(id==null && id>=0) id = 0;
            orderStatusEntity.setOrderStatusid(++id);
            orderStatusesByOrderid.add(orderStatusEntity);
            orders.setChangetime(orderStatusEntity.getStatusStartTime());
            ordersJpa.save(orders);
            one.setMaintenanceStatus(3);
            EvaluatesEntity e = new EvaluatesEntity();
            e.setEvaluateid(orders.getOrderid());
            e.setEmployeeid(one.getEmployeeid());
            e.setStatus(0);
            evaluatesJpa.save(e);
        }else if(maintenancesEntity.getMaintenanceStatus()==2){
             SalaryEntity salaryEntity = salaryJpa.getOne(one.getEmployeeid());
             one.setMaintenancePrice(one.getMaintenancePrice()+one.getMaintenanceHour()*salaryEntity.getHours());
            OrdersEntity orders = ordersJpa.findOrders(one.getCarid());
            orders.setPrice(orders.getPrice()+one.getMaintenancePrice());
            one.setMaintenanceStatus(2);
        }
        maintenancesJpa.save(one);
        return true;
    }

    @Override
    @Transactional
    public boolean updateMaintenance(MaintenancesEntity maintenancesEntity) {
        maintenancesJpa.save(maintenancesEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteMaintenance(List<Integer> ids) {
        List<MaintenancesEntity> maintenancesEntities = new ArrayList<>();
        ids.forEach(id -> {
            MaintenancesEntity maintenancesEntity = new MaintenancesEntity();
            maintenancesEntity.setMaintenanceid(id);
            maintenancesEntities.add(maintenancesEntity);
        });
        maintenancesJpa.deleteAll(maintenancesEntities);
        return true;
    }

    @Override
    public MaintenancesDto findOne(int id) {
        return maintenancesJpa.findOne(id);
    }

    @Override

    public boolean findOne(int carId, int orderid) {
        OrdersEntity one = ordersJpa.getOne(orderid);
        if (one.getEndTime() == null) {
            MaintenancesEntity maintenancesEntity = maintenancesJpa.findOne(carId, one.getStartTime());
            if (maintenancesEntity != null) return true;
        }
        return false;
    }

    @Override
    public List<MaintenancesDto> findByCarId(List<Integer> ids) {
        return maintenancesJpa.findByCarid(ids);
    }

    @Override
    public CePage<MaintenancesDto> list(Pageable pageable) {
        return page( maintenancesJpa.findAllDto(pageable),pageable,maintenancePartJpa.count());
    }

    @Override
    public List<MaintenancesDto> findAll() {
        return maintenancesJpa.findAllDto();
    }

    @Override
    public List<MaintenancesDto> findByEmployeeId(int id) {
            return maintenancesJpa.findAllDtoByEmployeeId(id);
    }

    @Override
    public List<MaintenancesDto> findDtoByCustomerId(int id) {
        return maintenancesJpa.findDtoByCustomerId(id);
    }

}
