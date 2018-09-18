package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenancesDto {
    private int maintenanceid;
    private String maintenanceName;
    private Double maintenancePrice;
    private Integer maintenanceStatus;
    private Date maintenanceTime;
    private Double maintenanceHour;
    private Integer employeeid;
    private String name;
    private Integer carid;
    private String brand;
    private Integer customerid;
    private String customerName;
}
