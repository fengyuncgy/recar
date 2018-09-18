package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDto {

    private int employeeid;
    private String name;
    private Double baseSalary;
    private Double addSalary;
    private Double finishCount;
    private Double monthCount;
    private Double hours;
    private Double addProportion;
}
