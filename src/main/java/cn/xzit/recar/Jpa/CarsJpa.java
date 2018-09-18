package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.CarsDto;
import cn.xzit.recar.bean.entity.CarsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsJpa extends BaseJpa<CarsEntity> {



    @Query("select new cn.xzit.recar.bean.domain.CarsDto(c.carid,c.brand,c.model,c.type,c.weight,c.licenseTag,c.color,c.buyTime,c.customerid,co.name) from CarsEntity c " +
            "left join c.customersByCustomerid co")
    List<CarsDto> findAllSort (Pageable  pageable);

    @Query("select new cn.xzit.recar.bean.domain.CarsDto(c.carid,c.brand,c.model,c.type,c.weight,c.licenseTag,c.color,c.buyTime,c.customerid,co.name) from CarsEntity c " +
            "left join c.customersByCustomerid co " +
            "where c.customerid = ?1 ")
    List<CarsDto> findOnes(int id);


    @Query("select count(c.carid) from CarsEntity c " +
            "where c.customerid = ?1 ")
    int count(int id);

    @Query("select new cn.xzit.recar.bean.domain.CarsDto(c.carid,c.brand,c.model,c.type,c.weight,c.licenseTag,c.color,c.buyTime,c.customerid,co.name) from CarsEntity c " +
            "left join c.customersByCustomerid co " +
            "where c.carid = ?1 ")
    CarsDto findDtoById (int carid);


    @Query("select c.carid from CarsEntity c where c.customerid=?1")
    List<Integer> findCarid(int cuId);


}
