package cn.xzit.recar.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars", schema = "recar", catalog = "")
public class CarsEntity {
    private int carid;
    private String brand;
    private String model;
    private String type;
    private Double weight;
    private String licenseTag;
    private String color;
    private Integer customerid;

    @Id
    @Column(name = "carid")
    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "weight")
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "license_tag")
    public String getLicenseTag() {
        return licenseTag;
    }

    public void setLicenseTag(String licenseTag) {
        this.licenseTag = licenseTag;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "customerid")
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsEntity that = (CarsEntity) o;
        return carid == that.carid &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(type, that.type) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(licenseTag, that.licenseTag) &&
                Objects.equals(color, that.color) &&
                Objects.equals(customerid, that.customerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carid, brand, model, type, weight, licenseTag, color, customerid);
    }
}
