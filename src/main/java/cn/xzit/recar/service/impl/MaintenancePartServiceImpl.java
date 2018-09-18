package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.MaintenancePartJpa;
import cn.xzit.recar.Jpa.MaintenancesJpa;
import cn.xzit.recar.Jpa.WarehouseJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancePartDto;
import cn.xzit.recar.bean.entity.MaintenancePartEntity;
import cn.xzit.recar.bean.entity.MaintenancesEntity;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import cn.xzit.recar.service.MaintenancePartService;
import cn.xzit.recar.service.ManufacturersService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MaintenancePartServiceImpl extends CommonService implements MaintenancePartService {
    @Autowired
    private MaintenancePartJpa maintenancePartJpa;

    @Autowired
    private MaintenancesJpa  maintenancesJpa;

    @Autowired
    private WarehouseJpa warehouseJpa;
    @Override
    public CePage<MaintenancePartDto> list(Pageable pageable) {
        return page(maintenancePartJpa.list(pageable), pageable, maintenancePartJpa.count());
    }

    @Override
    public List<MaintenancePartDto> findByMaintenanceid(int id) {
        return maintenancePartJpa.findByMaintenanceid(id);
    }

    @Override
    public boolean save(MaintenancePartEntity maintenancePartEntity) {
        MaintenancePartEntity m = maintenancePartJpa.findByMaintenanceidAndPartid(maintenancePartEntity.getMaintenanceid(), maintenancePartEntity.getPartid());
        if(m!=null)return false;
        WarehouseEntity one = warehouseJpa.getOne(maintenancePartEntity.getPartid());
        MaintenancesEntity maintenancesByMaintenanceid =maintenancesJpa.findByMaintenanceid(maintenancePartEntity.getMaintenanceid());
        int i = one.getNum() - maintenancePartEntity.getNum();if(i<0)return false;
        one.setNum(i);
        maintenancePartJpa.save(maintenancePartEntity);
         Double price = maintenancesByMaintenanceid.getMaintenancePrice() + maintenancePartEntity.getNum() * one.getOurPrice();
        maintenancesByMaintenanceid.setMaintenancePrice(maintenancesByMaintenanceid.getMaintenancePrice()==null?maintenancePartEntity.getNum() * one.getOurPrice():price);
        maintenancesJpa.save(maintenancesByMaintenanceid);
        warehouseJpa.save(one);
        return true;
    }

    @Override
    public boolean update(MaintenancePartEntity maintenancePartEntity) {
        List<Integer> list = new ArrayList<>();
        list.add(maintenancePartEntity.getMaintenancePartid());
         this.delete (list);
        MaintenancePartEntity m = maintenancePartJpa.findByMaintenanceidAndPartid(maintenancePartEntity.getMaintenanceid(), maintenancePartEntity.getPartid());
        if(m!=null)return false;
        WarehouseEntity one = warehouseJpa.getOne(maintenancePartEntity.getPartid());
        MaintenancesEntity maintenancesByMaintenanceid =maintenancesJpa.findByMaintenanceid(maintenancePartEntity.getMaintenanceid());
        int i = one.getNum() - maintenancePartEntity.getNum();if(i<0)return false;
        one.setNum(i);
        maintenancePartJpa.save(maintenancePartEntity);
        Double price = maintenancesByMaintenanceid.getMaintenancePrice() + maintenancePartEntity.getNum() * one.getOurPrice();
        maintenancesByMaintenanceid.setMaintenancePrice(maintenancesByMaintenanceid.getMaintenancePrice()==null?maintenancePartEntity.getNum() * one.getOurPrice():price);
        maintenancesJpa.save(maintenancesByMaintenanceid);
        warehouseJpa.save(one);
        return true;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        ids.forEach(id->{
            MaintenancePartEntity maintenancePartEntity = maintenancePartJpa.getOne(id);
            WarehouseEntity one = warehouseJpa.getOne(maintenancePartEntity.getPartid());
            int i = one.getNum() + maintenancePartEntity.getNum();
            one.setNum(i);
            MaintenancesEntity maintenancesByMaintenanceid =maintenancesJpa.findByMaintenanceid(maintenancePartEntity.getMaintenanceid());
            maintenancesByMaintenanceid.setMaintenancePrice(maintenancesByMaintenanceid.getMaintenancePrice()-maintenancePartEntity.getNum()*one.getOurPrice());
            maintenancesJpa.save(maintenancesByMaintenanceid);
            warehouseJpa.save(one);
            maintenancePartJpa.delete(maintenancePartEntity);
        });
        return true;
    }
}
