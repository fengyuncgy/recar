package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.WarehouseJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.WarehouseDto;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import cn.xzit.recar.service.WarehouseService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class WarehouseServiceImpl extends CommonService implements WarehouseService {

    @Autowired
    private WarehouseJpa warehouseJpa;

    @Override
    public CePage<WarehouseDto> list(Pageable pageable) {

        return page(warehouseJpa.list(pageable),pageable,warehouseJpa.count());
    }



    @Override
    @Transactional
    public boolean deleteWarehouse(List<Integer> ids) {
        int i=0;
        for (Integer id :ids){
            WarehouseEntity one = warehouseJpa.getOne(id);
            if(one!=null&&(one.getNum()==null||one.getNum()==0))
               warehouseJpa.deleteByI2d(id);
            else i++;

        }
        if (i==0)
            return true;
        else return false;
    }

    @Override
    @Transactional
    public boolean updateWarehouseNum(int id, int num) {
        WarehouseEntity one = warehouseJpa.getOne(id);
        one.setNum(one.getNum()+num);
        warehouseJpa.save(one);
        return true;
    }

    @Override
    public WarehouseDto findOne(int id) {
        return warehouseJpa.findOne(id);
    }

    @Override
    public boolean updatePrice(WarehouseEntity warehouseEntity) {
        WarehouseEntity one = warehouseJpa.getOne(warehouseEntity.getPartid());
        one.setOurPrice(warehouseEntity.getOurPrice());
        one.setInPrice(warehouseEntity.getInPrice());
        one.setErorrMessage(warehouseEntity.getErorrMessage());
        one.setPlace(warehouseEntity.getPlace());
        warehouseJpa.save(one);
        return true;
    }
}
