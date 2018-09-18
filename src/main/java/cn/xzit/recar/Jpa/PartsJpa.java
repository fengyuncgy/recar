package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.PartsDto;
import cn.xzit.recar.bean.entity.PartsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartsJpa extends BaseJpa<PartsEntity> {

    @Query("select max (p.partid) from PartsEntity p")
    Integer maxId();
    @Query("select new cn.xzit.recar.bean.domain.PartsDto(p.partid,p.partName,p.specification,p.partGroupid,g.groupName,m.manufacturerid,m.name) from PartsEntity p " +
            "left join  p.manufacturersByManufacturerid m " +
            "left join p.partGroupsByPartGroupid g " +
            "where p.partid = ?1")
    PartsDto findOne(int id);

    @Query("select new cn.xzit.recar.bean.domain.PartsDto(p.partid,p.partName,p.specification,p.partGroupid,g.groupName,m.manufacturerid,m.name) from PartsEntity p " +
            "left join  p.manufacturersByManufacturerid m " +
            "left join p.partGroupsByPartGroupid g " +
            "where p.partGroupid = ?1")
    List<PartsDto> findByPartGroupid(int id);
    @Query("select new cn.xzit.recar.bean.domain.PartsDto(p.partid,p.partName,p.specification,p.partGroupid,g.groupName,p.manufacturerid,m.name) from PartsEntity p " +
            "left join  p.manufacturersByManufacturerid m " +
            "left join p.partGroupsByPartGroupid g ")
    List<PartsDto> findAllDto();


    @Query("select new cn.xzit.recar.bean.domain.PartsDto(p.partid,p.partName,p.specification,p.partGroupid,g.groupName,p.manufacturerid,m.name) from PartsEntity p " +
            "left join  p.manufacturersByManufacturerid m " +
            "left join p.partGroupsByPartGroupid g ")
    List<PartsDto> findAllDto(Pageable  pageable);

}
