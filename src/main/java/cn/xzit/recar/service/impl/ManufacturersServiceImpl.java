package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.ManufacturersJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.ManufacturersDto;
import cn.xzit.recar.bean.entity.ManufacturersEntity;
import cn.xzit.recar.constant.RecarConstant;
import cn.xzit.recar.service.ManufacturersService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ManufacturersServiceImpl extends CommonService implements ManufacturersService {

    @Autowired
    private ManufacturersJpa manufacturersJpa;


    @Override
    public boolean save(ManufacturersEntity manufacturersEntity) {

        manufacturersJpa.save(manufacturersEntity);
        return true;
    }

    @Override
    public boolean update(ManufacturersEntity manufacturersEntity) {
        manufacturersJpa.save(manufacturersEntity);
        return true;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        List<ManufacturersEntity> manufacturersEntities = new ArrayList<>();
        ids.forEach(id->{
            ManufacturersEntity manufacturersEntity  = new ManufacturersEntity();
            manufacturersEntity.setManufacturerid(id);
            manufacturersEntities.add(manufacturersEntity);
        });
        manufacturersJpa.deleteAll(manufacturersEntities);
        return true;
    }

    @Override
    public ManufacturersDto findOne(Integer id) {
        ManufacturersDto manufacturersDto = manufacturersJpa.findAllDtoById(id);
//        handleTime(manufacturersDto);
        return manufacturersDto;
    }

    @Override
    public List<ManufacturersDto> findAll() {
        List<ManufacturersDto> allDto = manufacturersJpa.findAllDto();
//        allDto.forEach(dto->handleTime(dto));
        return allDto;
    }

    @Override
    public CePage<ManufacturersDto> list(Pageable pageable) {
        return page(manufacturersJpa.list(pageable),pageable,manufacturersJpa.count());
    }

    private  void handleTime (ManufacturersDto manufacturersDto) {
        manufacturersDto.setCreate(TimeUtil.dateTime(manufacturersDto.getCreateTime().getTime()));
        manufacturersDto.setStart(TimeUtil.dateTime(manufacturersDto.getStartTime().getTime()));
    }
}
