package cn.xzit.recar.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "maintenances", schema = "recar", catalog = "")
public class MaintenancesEntity {
    private int maintenanceid;
    private String maintenanceName;
    private Double maintenancePrice;
    private Integer maintenanceStatus;
    private Timestamp maintenanceTime;
    private Integer carid;
    private Integer employeeid;

    @Id
    @Column(name = "maintenanceid")
    public int getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(int maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    @Basic
    @Column(name = "maintenance_name")
    public String getMaintenanceName() {
        return maintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    @Basic
    @Column(name = "maintenance_price")
    public Double getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(Double maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

    @Basic
    @Column(name = "maintenance_status")
    public Integer getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(Integer maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    @Basic
    @Column(name = "maintenance_time")
    public Timestamp getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Timestamp maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    @Basic
    @Column(name = "carid")
    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "employeeid")
    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenancesEntity that = (MaintenancesEntity) o;
        return maintenanceid == that.maintenanceid &&
                Objects.equals(maintenanceName, that.maintenanceName) &&
                Objects.equals(maintenancePrice, that.maintenancePrice) &&
                Objects.equals(maintenanceStatus, that.maintenanceStatus) &&
                Objects.equals(maintenanceTime, that.maintenanceTime) &&
                Objects.equals(carid, that.carid) &&
                Objects.equals(employeeid, that.employeeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceid, maintenanceName, maintenancePrice, maintenanceStatus, maintenanceTime, carid, employeeid);
    }
}
