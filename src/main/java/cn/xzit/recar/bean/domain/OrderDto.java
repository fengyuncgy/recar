package cn.xzit.recar.bean.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private int orderid;
    private String orderNumber;
    private String name;
    private Date startTime;
    private Date endTime;
    private Double price;
    private Integer orderStatusid;
    private Integer type;
    private Integer carid;
    private String brand;
}
