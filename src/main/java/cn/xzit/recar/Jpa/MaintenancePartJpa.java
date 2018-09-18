package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.MaintenancePartDto;
import cn.xzit.recar.bean.domain.MaintenancesDto;
import cn.xzit.recar.bean.entity.MaintenancePartEntity;
import cn.xzit.recar.bean.entity.MaintenancesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaintenancePartJpa extends BaseJpa<MaintenancePartEntity> {

    @Query("select max(m.maintenancePartid) from MaintenancePartEntity m ")
    int maxId();

    @Query("select new cn.xzit.recar.bean.domain.MaintenancePartDto(mp.maintenancePartid,mp.maintenanceid,m.maintenanceName" +
            ",m.maintenanceTime,e.employeeid,e.name,c.carid,c.brand,mp.partid,p.partName,mp.num) from MaintenancePartEntity mp " +
            "left join mp.partsByPartid p " +
            "left join mp.maintenancesByMaintenanceid m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join p.warehouseByPartid w")
    List<MaintenancePartDto> list(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.MaintenancePartDto(mp.maintenancePartid,mp.maintenanceid,m.maintenanceName" +
            ",m.maintenanceTime,e.employeeid,e.name,c.carid,c.brand,mp.partid,p.partName,mp.num) from MaintenancePartEntity mp " +
            "left join mp.partsByPartid p " +
            "left join mp.maintenancesByMaintenanceid m " +
            "left join m.carsByCarid c " +
            "left join m.employeesByEmployeeid e " +
            "left join p.warehouseByPartid w " +
            "where mp.maintenanceid = ?1 ")
    List<MaintenancePartDto> findByMaintenanceid(int id);

    @Query("select m from MaintenancePartEntity m " +
            "where m.maintenanceid=?1 and m.partid=?2")
    MaintenancePartEntity findByMaintenanceidAndPartid(int maintenanceid,int partid);
}
