package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.PartsJpa;
import cn.xzit.recar.Jpa.WarehouseJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartsDto;
import cn.xzit.recar.bean.entity.PartsEntity;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import cn.xzit.recar.service.PartsService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PartsServiceImpl extends CommonService implements PartsService {

    @Autowired
    private PartsJpa partsJpa;
    @Autowired
    private WarehouseJpa warehouseJpa;

    @Override
    public boolean addPart(PartsEntity partsEntity) {
        Integer integer = partsJpa.maxId();
        if (integer == null) {
            integer = 0;
        } else {
            integer++;
        }
        partsEntity.setPartid(integer);
        partsJpa.save(partsEntity);
        WarehouseEntity w = new WarehouseEntity();
        w.setPartid(integer);
        w.setNum(0);
        warehouseJpa.save(w);
        return true;
    }

    @Override
    public boolean updatePart(PartsEntity partsEntity) {
        partsJpa.save(partsEntity);
        return true;
    }


    @Override
    public boolean deletePart(List<Integer> ids) {
        List<PartsEntity> partsEntities = new ArrayList<>();
        ids.forEach(id -> {
            PartsEntity partsEntity = new PartsEntity();
            partsEntity.setPartid(id);
            WarehouseEntity warehouseEntity = new WarehouseEntity();
            warehouseEntity.setPartid(id);
            warehouseEntity.setNum(0);
            partsEntity.setWarehouseByPartid(warehouseEntity);
            partsEntities.add(partsEntity);
        });
        partsJpa.deleteAll(partsEntities);
        return true;
    }

    @Override
    public PartsDto findOne(int id) {

        return partsJpa.findOne(id);
    }

    @Override
    public List<PartsDto> findAll() {
        return partsJpa.findAllDto();
    }

    @Override
    public CePage<PartsDto> list(Pageable pageable) {

        return page(partsJpa.findAllDto(pageable), pageable, partsJpa.count());
    }

    @Override
    public List<PartsDto> findAllByGroupId(int id) {
        return partsJpa.findByPartGroupid(id);
    }
}
