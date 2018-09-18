package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.MaintenancesDto;
import cn.xzit.recar.bean.entity.MaintenancesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface
MaintenancesJpa extends BaseJpa<MaintenancesEntity> {


    @Query("select m from MaintenancesEntity m " +
            "where m.carid = ?1 and m.maintenanceTime>=?2  ")
    MaintenancesEntity findOne(int carId, Timestamp timestamp);

    @Query("select max (m.maintenanceid) from MaintenancesEntity m")
    Integer maxId();

    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu " +
            "where m.maintenanceid=?1 ")
    MaintenancesDto findOne(int id);


    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu " +
            "where m.carid in ?1 ")
    List<MaintenancesDto> findByCarid(List<Integer> id);

    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu ")
    List<MaintenancesDto> findAllDto();

    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu ")
    List<MaintenancesDto> findAllDto(Pageable pageable);


    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu " +
            "where m.employeeid =?1 ")
    List<MaintenancesDto> findAllDtoByEmployeeId(int id);

    @Query("select new cn.xzit.recar.bean.domain.MaintenancesDto(m.maintenanceid,m.maintenanceName,m.maintenancePrice,m.maintenanceStatus,m.maintenanceTime,m.maintenanceHour," +
            "m.employeeid,e.name,m.carid,c.brand,cu.customerid,cu.name) " +
            "from MaintenancesEntity m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join c.customersByCustomerid cu " +
            "where c.customerid =?1 order by  m.maintenanceTime desc ")
    List<MaintenancesDto> findDtoByCustomerId(int id);

    @Query("select m from MaintenancesEntity m" +
            " where m.maintenanceid=?1")
    MaintenancesEntity findByMaintenanceid(int id);
}
