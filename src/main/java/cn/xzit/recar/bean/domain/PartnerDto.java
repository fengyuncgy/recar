package cn.xzit.recar.bean.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {
    private int partnerid;
    private String name;
    private Integer age;
    private String tel;

}
