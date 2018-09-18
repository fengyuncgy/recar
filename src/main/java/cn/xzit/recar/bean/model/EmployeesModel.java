package cn.xzit.recar.bean.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesModel implements Serializable {
    private Integer employeeid;
    private String name;
    private String account;
    private String password;
    private String repassword;
    private Integer sex;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日")
    private Date birth;
    private String address;
    private String tel;
    private Integer type;
}
