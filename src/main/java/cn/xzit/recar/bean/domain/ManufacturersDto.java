package cn.xzit.recar.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturersDto {
    private int manufacturerid;
    private String name;
    private Date createTime;
    private Date startTime;
    private String telName1;
    private String telNum1;
    private String telName2;
    private String telNum2;

    public ManufacturersDto(int manufacturerid, String name, Date createTime, Date startTime, String telName1, String telNum1, String telName2, String telNum2) {
        this.manufacturerid = manufacturerid;
        this.name = name;
        this.createTime = createTime;
        this.startTime = startTime;
        this.telName1 = telName1;
        this.telNum1 = telNum1;
        this.telName2 = telName2;
        this.telNum2 = telNum2;
    }

    private String create;
    private String start;
}
