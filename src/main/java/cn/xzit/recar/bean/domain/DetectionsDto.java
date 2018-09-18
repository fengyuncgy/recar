package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionsDto {
    private int detectionid;
    private String detectionName;
    private Date detectionTime;
    private Integer detectionStatus;
    private String message;
    private Integer employeeid;
    private String name;
    private Integer carid;
    private String brand;
    private Integer customerid;
    private String customerName;

}
