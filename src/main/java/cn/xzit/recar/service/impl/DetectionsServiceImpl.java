package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.DetectionsJpa;
import cn.xzit.recar.Jpa.MaintenancesJpa;
import cn.xzit.recar.Jpa.OrderStatusJpa;
import cn.xzit.recar.Jpa.OrdersJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.DetectionsDto;
import cn.xzit.recar.bean.entity.*;
import cn.xzit.recar.service.DetectionsService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class DetectionsServiceImpl extends CommonService implements DetectionsService {

    @Autowired
    private DetectionsJpa detectionsJpa;

    @Autowired
    private OrdersJpa ordersJpa ;

    @Autowired
    private OrderStatusJpa orderStatusJpa ;
    @Autowired
    private MaintenancesJpa maintenancesJpa;
    @Override
    public CePage<DetectionsDto> list(Pageable pageable) {
        return page(detectionsJpa.findAllSort(pageable),pageable,detectionsJpa.count());
    }

    @Override
    public boolean addDetection(DetectionsEntity detectionsEntity) {
        detectionsJpa.save(detectionsEntity);
        return true;
    }

    @Override
    public boolean updateStatus(int status, int id) {
        detectionsJpa.updateStatus(status,id);
        return true;
    }

    @Override
    public boolean deleteDetection(List<Integer> ids) {
        List<DetectionsEntity> detectionsEntities = new ArrayList<>();
        ids.forEach(id->{
            DetectionsEntity detectionsEntity = new DetectionsEntity();
            detectionsEntity.setDetectionid(id);
            detectionsEntities.add(detectionsEntity);
        });
        detectionsJpa.deleteAll(detectionsEntities);
        return true;
    }

    @Override
    public List<DetectionsDto> findAll() {
        return detectionsJpa.findAllDto();
    }

    @Override
    public List<DetectionsDto> findByEmployeeid(int id) {
        return detectionsJpa.findByEmployeeid(id);
    }

    @Override
    public List<DetectionsDto> findByCarid(List<Integer> id) {
        return detectionsJpa.findByCarid(id);
    }

    @Override
    public DetectionsDto findOne(int id) {
        return detectionsJpa.findOne(id);
    }



    // 0 未检查  1 检查中  2 检查完成 4放弃检查
    @Override
    public boolean updateStatus(DetectionsEntity detectionsEntity){
        DetectionsEntity one = detectionsJpa.getOne(detectionsEntity.getDetectionid());
        Integer status = detectionsEntity.getDetectionStatus();

        //订单改变状态
        if (status == 2){
            OrdersEntity orders = ordersJpa.findOrders(one.getCarid());
            if(orders == null) return false;
            orders.setChangetime(TimeUtil.nowTime());
            Collection<OrderStatusEntity> orderStatusesByOrderid = orders.getOrderStatusesByOrderid();
            for(OrderStatusEntity orderStatusEntity :orderStatusesByOrderid){
                if(orderStatusEntity.getType()>= 2) return false;
                if(orderStatusEntity.getType()==1) {
                    orderStatusEntity.setStatusEndTime(TimeUtil.nowTime());
                }
            }
            OrderStatusEntity orderStatusEntity = new OrderStatusEntity();
            orderStatusEntity.setType(2);
            orderStatusEntity.setStatusStartTime(TimeUtil.nowTime());
            orderStatusEntity.setOrderid(orders.getOrderid());
            orderStatusEntity.setMessage("维修状态");
            Integer id = orderStatusJpa.maxId();
            if(id==null && id>=0) id = 0;
            orderStatusEntity.setOrderStatusid(++id);
            orderStatusesByOrderid.add(orderStatusEntity);
            orders.setChangetime(orderStatusEntity.getStatusStartTime());
            ordersJpa.save(orders);
            MaintenancesEntity maintenancesEntity = new MaintenancesEntity();
            maintenancesEntity.setMaintenancePrice(0D);
            maintenancesEntity.setMaintenanceStatus(0);
            maintenancesEntity.setMaintenanceName(one.getDetectionName());
            maintenancesEntity.setCarid(one.getCarid());
            maintenancesJpa.save(maintenancesEntity);
        }
        //订单结束
        if(status==4 && one.getDetectionStatus() == 0) {
            OrdersEntity orders = ordersJpa.findOrders(detectionsEntity.getCarid());
            orders.setEndTime(TimeUtil.nowTime());
            orders.setChangetime(TimeUtil.nowTime());
        }
        detectionsJpa.save(detectionsEntity);
        return true;
    }

    @Override
    public boolean updateDetection(DetectionsEntity detectionsEntity) {
        detectionsJpa.save(detectionsEntity);
        return true;

    }
}
