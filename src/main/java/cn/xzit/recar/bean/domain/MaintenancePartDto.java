package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancePartDto {
    private int maintenancePartid;
    private int maintenanceid;
    private String maintenanceName;
    private Date maintenanceTime;
    private int employeeid;
    private String name;
    private int carid;
    private String brand;
    private int partid;
    private String partName;
    private Integer num;

}
