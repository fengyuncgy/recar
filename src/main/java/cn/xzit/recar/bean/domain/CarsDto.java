package cn.xzit.recar.bean.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDto {
    private int carid;
    private String brand;
    private String model;
    private String type;
    private Double weight;
    private String licenseTag;
    private String color;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date buyTime;
    private Integer customerid;
    private String name;

    public CarsDto(int carid, String brand, String model, String type, Double weight, String licenseTag, String color, Date buyTime, Integer customerid, String name) {
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.weight = weight;
        this.licenseTag = licenseTag;
        this.color = color;
        this.buyTime = buyTime;
        this.customerid = customerid;
        this.name = name;
    }

    private String buyTimeStr;


}
