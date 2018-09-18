package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.DetectionsDto;
import cn.xzit.recar.bean.entity.DetectionsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetectionsJpa extends BaseJpa<DetectionsEntity> {

    @Query("select new cn.xzit.recar.bean.domain.DetectionsDto(d.detectionid,d.detectionName,d.detectionTime,d.detectionStatus,d.message," +
            "e.employeeid,e.name,c.carid,c.brand,cu.customerid,cu.name) from DetectionsEntity d " +
            "left join d.employeesByEmployeeid  e " +
            "left join d.carsByCarid c " +
            "left join c.customersByCustomerid cu")
    List<DetectionsDto> findAllDto();

    @Query("select new cn.xzit.recar.bean.domain.DetectionsDto(d.detectionid,d.detectionName,d.detectionTime,d.detectionStatus,d.message," +
            "e.employeeid,e.name,c.carid,c.brand,cu.customerid,cu.name) from DetectionsEntity d " +
            "left join d.employeesByEmployeeid  e " +
            "left join d.carsByCarid c " +
            "left join c.customersByCustomerid cu")
    List<DetectionsDto> findAllSort(Pageable pageable);
    @Query("select new cn.xzit.recar.bean.domain.DetectionsDto(d.detectionid,d.detectionName,d.detectionTime,d.detectionStatus,d.message," +
            "e.employeeid,e.name,c.carid,c.brand,cu.customerid,cu.name) from DetectionsEntity d " +
            "left join d.employeesByEmployeeid  e " +
            "left join d.carsByCarid c " +
            "left join c.customersByCustomerid cu " +
            "where d.detectionid = ?1")
    DetectionsDto findOne(int id);
    @Query("select new cn.xzit.recar.bean.domain.DetectionsDto(d.detectionid,d.detectionName,d.detectionTime,d.detectionStatus,d.message," +
            "e.employeeid,e.name,c.carid,c.brand,cu.customerid,cu.name) from DetectionsEntity d " +
            "left join d.employeesByEmployeeid  e " +
            "left join d.carsByCarid c " +
            "left join c.customersByCustomerid cu " +
            "where d.employeeid = ?1")
    List<DetectionsDto> findByEmployeeid(int id);

    @Query("update DetectionsEntity d set d.detectionStatus=?1 where d.detectionid=?2")
    @Modifying(clearAutomatically = true)
    void updateStatus(int status ,int id);



    @Query("select new cn.xzit.recar.bean.domain.DetectionsDto(d.detectionid,d.detectionName,d.detectionTime,d.detectionStatus,d.message," +
            "e.employeeid,e.name,c.carid,c.brand,cu.customerid,cu.name) from DetectionsEntity d " +
            "left join d.employeesByEmployeeid  e " +
            "left join d.carsByCarid c " +
            "left join c.customersByCustomerid cu " +
            "where d.carid in ?1")
    List<DetectionsDto> findByCarid(List<Integer> id);
}
