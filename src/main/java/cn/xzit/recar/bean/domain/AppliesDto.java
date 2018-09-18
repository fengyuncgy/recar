package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliesDto {
    private int applyid;
    private String applyName;
    private Date applyTime;
    private Double applyPrice;
    private Integer applyStatus;
    private Date maintainTime;
    private Integer carid;
    private String brand;
    private int customerid;
    private String name;
}
