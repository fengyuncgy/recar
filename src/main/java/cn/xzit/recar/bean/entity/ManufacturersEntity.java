package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "manufacturers", schema = "recar", catalog = "")
public class ManufacturersEntity {
    private int manufacturerid;
    private String name;
    private Date createTime;
    private Date startTime;
    private String telName1;
    private String telNum1;
    private String telName2;
    private String telNum2;
    private Collection<PartsEntity> partsByManufacturerid;

    @Id
    @Column(name = "manufacturerid", nullable = false)
    public int getManufacturerid() {
        return manufacturerid;
    }

    public void setManufacturerid(int manufacturerid) {
        this.manufacturerid = manufacturerid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "tel_name1", nullable = true, length = 20)
    public String getTelName1() {
        return telName1;
    }

    public void setTelName1(String telName1) {
        this.telName1 = telName1;
    }

    @Basic
    @Column(name = "tel_num1", nullable = true, length = 11)
    public String getTelNum1() {
        return telNum1;
    }

    public void setTelNum1(String telNum1) {
        this.telNum1 = telNum1;
    }

    @Basic
    @Column(name = "tel_name2", nullable = true, length = 20)
    public String getTelName2() {
        return telName2;
    }

    public void setTelName2(String telName2) {
        this.telName2 = telName2;
    }

    @Basic
    @Column(name = "tel_num2", nullable = true, length = 11)
    public String getTelNum2() {
        return telNum2;
    }

    public void setTelNum2(String telNum2) {
        this.telNum2 = telNum2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufacturersEntity that = (ManufacturersEntity) o;
        return manufacturerid == that.manufacturerid &&
                Objects.equals(name, that.name) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(telName1, that.telName1) &&
                Objects.equals(telNum1, that.telNum1) &&
                Objects.equals(telName2, that.telName2) &&
                Objects.equals(telNum2, that.telNum2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerid, name, createTime, startTime, telName1, telNum1, telName2, telNum2);
    }

    @OneToMany(mappedBy = "manufacturersByManufacturerid")
    public Collection<PartsEntity> getPartsByManufacturerid() {
        return partsByManufacturerid;
    }

    public void setPartsByManufacturerid(Collection<PartsEntity> partsByManufacturerid) {
        this.partsByManufacturerid = partsByManufacturerid;
    }
}
