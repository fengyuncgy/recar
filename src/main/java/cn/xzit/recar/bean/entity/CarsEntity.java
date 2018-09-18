package cn.xzit.recar.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date buyTime;
    private Integer customerid;
    private Collection<AppliesEntity> appliesByCarid;
    private CustomersEntity customersByCustomerid;
    private Collection<DetectionsEntity> detectionsByCarid;
    private Collection<MaintenancesEntity> maintenancesByCarid;
    private Collection<OrdersEntity> ordersByCarid;

    @Id
    @Column(name = "carid", nullable = false)
    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "brand", nullable = true, length = 40)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 40)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 40)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "license_tag", nullable = true, length = 10)
    public String getLicenseTag() {
        return licenseTag;
    }

    public void setLicenseTag(String licenseTag) {
        this.licenseTag = licenseTag;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 10)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "customerid", nullable = true)
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "buy_time", nullable = true)
    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
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

    @OneToMany(mappedBy = "carsByCarid")
    public Collection<AppliesEntity> getAppliesByCarid() {
        return appliesByCarid;
    }

    public void setAppliesByCarid(Collection<AppliesEntity> appliesByCarid) {
        this.appliesByCarid = appliesByCarid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid",insertable=false,updatable=false)
    public CustomersEntity getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(CustomersEntity customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }

    @OneToMany(mappedBy = "carsByCarid")
    public Collection<DetectionsEntity> getDetectionsByCarid() {
        return detectionsByCarid;
    }

    public void setDetectionsByCarid(Collection<DetectionsEntity> detectionsByCarid) {
        this.detectionsByCarid = detectionsByCarid;
    }

    @OneToMany(mappedBy = "carsByCarid")
    public Collection<MaintenancesEntity> getMaintenancesByCarid() {
        return maintenancesByCarid;
    }

    public void setMaintenancesByCarid(Collection<MaintenancesEntity> maintenancesByCarid) {
        this.maintenancesByCarid = maintenancesByCarid;
    }

    @OneToMany(mappedBy = "carsByCarid")
    public Collection<OrdersEntity> getOrdersByCarid() {
        return ordersByCarid;
    }

    public void setOrdersByCarid(Collection<OrdersEntity> ordersByCarid) {
        this.ordersByCarid = ordersByCarid;
    }
}
