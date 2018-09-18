package cn.xzit.recar.bean.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto implements Serializable {

    private int employeeid;
    private String name;
    private String account;
    private Integer sex;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日")
    private Date date;
    private String address;
    private String tel;
    private Integer type;
    private Integer status;

}
