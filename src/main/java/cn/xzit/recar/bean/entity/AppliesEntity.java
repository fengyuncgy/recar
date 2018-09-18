package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "applies", schema = "recar", catalog = "")
public class AppliesEntity {
    private int applyid;
    private String applyName;
    private Timestamp applyTime;
    private Double applyPrice;
    private String error;
    private Integer applyStatus;
    private Timestamp maintainTime;
    private Integer carid;
    private CarsEntity carsByCarid;

    @Id
    @Column(name = "applyid", nullable = false)
    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    @Basic
    @Column(name = "apply_name", nullable = true, length = 50)
    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    @Basic
    @Column(name = "apply_time", nullable = true)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "apply_price", nullable = true, precision = 0)
    public Double getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(Double applyPrice) {
        this.applyPrice = applyPrice;
    }

    @Basic
    @Column(name = "error", nullable = true, length = 100)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Basic
    @Column(name = "apply_status", nullable = true)
    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Basic
    @Column(name = "maintain_time", nullable = true)
    public Timestamp getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Timestamp maintainTime) {
        this.maintainTime = maintainTime;
    }

    @Basic
    @Column(name = "carid", nullable = true)
    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppliesEntity that = (AppliesEntity) o;
        return applyid == that.applyid &&
                Objects.equals(applyName, that.applyName) &&
                Objects.equals(applyTime, that.applyTime) &&
                Objects.equals(applyPrice, that.applyPrice) &&
                Objects.equals(error, that.error) &&
                Objects.equals(applyStatus, that.applyStatus) &&
                Objects.equals(maintainTime, that.maintainTime) &&
                Objects.equals(carid, that.carid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(applyid, applyName, applyTime, applyPrice, error, applyStatus, maintainTime, carid);
    }

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carid",insertable=false,updatable=false)
    public CarsEntity getCarsByCarid() {
        return carsByCarid;
    }

    public void setCarsByCarid(CarsEntity carsByCarid) {
        this.carsByCarid = carsByCarid;
    }
}
