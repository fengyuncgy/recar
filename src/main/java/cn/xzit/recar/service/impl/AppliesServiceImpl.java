package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.*;
import cn.xzit.recar.bean.domain.AppliesDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.*;
import cn.xzit.recar.constant.RecarConstant;
import cn.xzit.recar.service.AppliesService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service
public class AppliesServiceImpl extends CommonService implements AppliesService {

    @Autowired
    private AppliesJpa appliesJpa;

    @Autowired

    private DetectionsJpa detectionsJpa;

    @Autowired
    private OrdersJpa ordersJpa;

    @Autowired
    private OrderStatusJpa orderStatusJpa;

    @Override
    public boolean addApplies(AppliesEntity appliesEntity) {
        OrdersEntity o = ordersJpa.findOrders(appliesEntity.getCarid());
        if(o!=null) return false;
        SimpleDateFormat sdf = new SimpleDateFormat(RecarConstant.datetimes);
        appliesEntity.setApplyTime(TimeUtil.nowTime());
        appliesJpa.save(appliesEntity);
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setCarid(appliesEntity.getCarid());
        ordersEntity.setName(appliesEntity.getApplyName()+"订单");
        ordersEntity.setStartTime(TimeUtil.nowTime());
        ordersEntity.setChangetime(ordersEntity.getStartTime());
        ordersEntity.setOrderNumber(sdf.format(ordersEntity.getStartTime()));
        ordersEntity.setPrice(20D);
        List<OrderStatusEntity> orderStatusEntities = new ArrayList<>();
        OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
        orderStatusEntity.setStatusStartTime(TimeUtil.nowTime());
        orderStatusEntity.setMessage("预约阶段");
        Integer id = orderStatusJpa.maxId();
        if(id==null) id = 0;
        orderStatusEntity.setOrderStatusid(++id);
        orderStatusEntity.setType(0);
        id=ordersJpa.maxId();
        if(id==null) id = 0;
        orderStatusEntity.setOrderid(++id);
        ordersEntity.setOrderid(orderStatusEntity.getOrderid());
        orderStatusEntities.add(orderStatusEntity);
        ordersEntity.setOrderStatusesByOrderid(orderStatusEntities);

        ordersJpa.save(ordersEntity);
        return true;
    }

    @Override
    public boolean updateApplies(AppliesEntity appliesEntity) {
        if(appliesEntity.getApplyid()<=0) return false;
        appliesJpa.save(appliesEntity);
        return true;
    }

    @Override
    public boolean deleteApplies(List<Integer> ids) {
        List<AppliesEntity> appliesEntities = new ArrayList<>();

        for (Integer id:ids){
            if(id==null)continue;
            AppliesEntity  appliesEntity = appliesJpa.getOne(id);
            appliesEntities.add(appliesEntity);
            OrdersEntity o = ordersJpa.findOrders(appliesEntity.getCarid());
            ordersJpa.delete(o);
        }
        appliesJpa.deleteAll(appliesEntities);

        return true;
    }

    @Override
    public CePage<AppliesDto> list(Pageable pageable) {
        return page(appliesJpa.findAllBySort(pageable),pageable,appliesJpa.count());
    }

    @Override
    public List<AppliesDto> getOnes( int id) {
        return appliesJpa.findOnes(id);
    }

    @Override
    public AppliesDto findOne(int id) {
        return findOne(id);
    }
//0 未付款 1已付款 2审核成功 3审核失败 4用户同意
    @Override
    public boolean updateStatus(AppliesEntity apply) {
        AppliesEntity appliesEntity = appliesJpa.getOne(apply.getApplyid());
        int status =apply.getApplyStatus();
        appliesEntity.setApplyStatus(status);
        if(status == 1){
            appliesEntity.setApplyTime(new Timestamp(System.currentTimeMillis()));
        }else if (status == 3 ||status==5){
            OrdersEntity o = ordersJpa.findOrders(appliesEntity.getCarid());
            o.setEndTime(TimeUtil.nowTime());
            ordersJpa.save(o);
        }else if(status == 4){
            OrdersEntity o = ordersJpa.findOrders(appliesEntity.getCarid());
            Collection<OrderStatusEntity> orders = o.getOrderStatusesByOrderid();
            List<OrderStatusEntity> orderStatusEntities = new ArrayList<>();
            orders.forEach(os->{
                if(os.getType()==0) {
                    os.setStatusEndTime(TimeUtil.nowTime());
                    orderStatusEntities.add(os);
                }
            });
            OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
            orderStatusEntity.setStatusStartTime(TimeUtil.nowTime());
            orderStatusEntity.setMessage("检查状态");
            Integer id = orderStatusJpa.maxId();
            if(id==null) id = 0;
            orderStatusEntity.setOrderStatusid(++id);
            orderStatusEntity.setType(1);
            orderStatusEntity.setOrderid(o.getOrderid());
            orderStatusEntities.add(orderStatusEntity);
            o.setOrderStatusesByOrderid(orderStatusEntities);
            ordersJpa.save(o);
        }else if(status==2){
            DetectionsEntity detectionsEntity =new DetectionsEntity();
            detectionsEntity.setDetectionTime(appliesEntity.getMaintainTime());
            detectionsEntity.setDetectionStatus(0);
            CarsEntity carsByCarid = appliesEntity.getCarsByCarid();
            detectionsEntity.setCarid(carsByCarid.getCarid());
            detectionsEntity.setDetectionName(carsByCarid.getCustomersByCustomerid().getName()+"的"+carsByCarid.getBrand());
            detectionsJpa.save(detectionsEntity);
        }
        appliesJpa.save(appliesEntity);
        return true;
    }



}
