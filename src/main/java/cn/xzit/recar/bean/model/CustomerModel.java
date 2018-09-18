package cn.xzit.recar.bean.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

    private int customerid;
    private String name;
    private String account;
    private String password;
    private String tel;
    private Integer sex;
    private Integer age;
}
