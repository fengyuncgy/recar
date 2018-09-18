package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowPartDto {
    private int flowid;
    private Date flowTime;
    private String message;
    private Integer employeeid;
    private String name;
    private Integer fpid;
    private Integer partid;
    private String partName;
    private Integer num;

}
