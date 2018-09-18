package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int customerid;
    private String name;
    private String account;
    private String tel;
    private Integer sex;
    private Integer age;
    private Date time;
    private int  status;
    private String timeStr;

    public CustomerDto(int customerid, String name, String account, String tel, Integer sex, Integer age, Date time,int  status) {
        this.customerid = customerid;
        this.name = name;
        this.account = account;
        this.tel = tel;
        this.sex = sex;
        this.age = age;
        this.time = time;
        this.status=status;
    }
}
