package cn.xzit.recar.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "applies", schema = "recar", catalog = "")
public class AppliesEntity {
    private int applyid;
    private String applyName;
    private Timestamp applyTime;
    private BigDecimal applyPrice;
    private String error;
    private Integer applyStatus;
    private Timestamp maintainTime;
    private Integer carid;

    @Id
    @Column(name = "applyid")
    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    @Basic
    @Column(name = "apply_name")
    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    @Basic
    @Column(name = "apply_time")
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "apply_price")
    public BigDecimal getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(BigDecimal applyPrice) {
        this.applyPrice = applyPrice;
    }

    @Basic
    @Column(name = "error")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Basic
    @Column(name = "apply_status")
    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Basic
    @Column(name = "maintain_time")
    public Timestamp getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(Timestamp maintainTime) {
        this.maintainTime = maintainTime;
    }

    @Basic
    @Column(name = "carid")
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
}
