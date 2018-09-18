package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluatesDto {

    private int evaluateid;
    private String orderName;
    private Integer server;
    private Integer maintenance;
    private Integer value;
    private Integer status;
    private Integer employeeid;
    private String name;
}
