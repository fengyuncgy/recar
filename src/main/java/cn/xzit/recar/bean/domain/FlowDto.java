package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowDto {
    private int flowid;
    private Date flowTime;
    private String message;
    private Integer employeeid;
    private String name;

}
