package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.ManufacturersDto;
import cn.xzit.recar.bean.entity.ManufacturersEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManufacturersService {

    boolean save(ManufacturersEntity manufacturersEntity);

    boolean update(ManufacturersEntity manufacturersEntity);

    boolean delete(List<Integer> ids);

    ManufacturersDto findOne(Integer id);

    List<ManufacturersDto> findAll();

    CePage<ManufacturersDto> list(Pageable pageable);


}
