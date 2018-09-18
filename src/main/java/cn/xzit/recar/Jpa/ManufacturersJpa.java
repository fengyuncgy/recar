package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.ManufacturersDto;
import cn.xzit.recar.bean.entity.ManufacturersEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManufacturersJpa extends BaseJpa<ManufacturersEntity> {

    @Query("select new cn.xzit.recar.bean.domain.ManufacturersDto(m.manufacturerid,m.name,m.createTime,m.startTime,m.telName1,m.telNum1,m.telName2,m.telNum2) " +
            "from ManufacturersEntity m ")
    List<ManufacturersDto> findAllDto();

    @Query("select new cn.xzit.recar.bean.domain.ManufacturersDto(m.manufacturerid,m.name,m.createTime,m.startTime,m.telName1,m.telNum1,m.telName2,m.telNum2) " +
            "from ManufacturersEntity m "+
            "where m.manufacturerid = ?1")
    ManufacturersDto findAllDtoById(int id);


    @Query("select new cn.xzit.recar.bean.domain.ManufacturersDto(m.manufacturerid,m.name,m.createTime,m.startTime,m.telName1,m.telNum1,m.telName2,m.telNum2) " +
            "from ManufacturersEntity m ")
    List<ManufacturersDto> list(Pageable pageable);
}
