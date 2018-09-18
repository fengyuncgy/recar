package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "maintenances", schema = "recar", catalog = "")
public class MaintenancesEntity {
    private int maintenanceid;
    private String maintenanceName;
    private Double maintenancePrice;
    private Integer maintenanceStatus;
    private Timestamp maintenanceTime;
    private Double maintenanceHour;
    private Integer carid;
    private Integer employeeid;
    private Collection<MaintenancePartEntity> maintenancePartsByMaintenanceid;
    private CarsEntity carsByCarid;
    private EmployeesEntity employeesByEmployeeid;

    @Id
    @Column(name = "maintenanceid", nullable = false)
    public int getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(int maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    @Basic
    @Column(name = "maintenance_name", nullable = true, length = 40)
    public String getMaintenanceName() {
        return maintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    @Basic
    @Column(name = "maintenance_price", nullable = true, precision = 0)
    public Double getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(Double maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

    @Basic
    @Column(name = "maintenance_status", nullable = true)
    public Integer getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(Integer maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    @Basic
    @Column(name = "maintenance_time", nullable = true)
    public Timestamp getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Timestamp maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }


    @Basic
    @Column(name = "carid", nullable = true)
    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "employeeid", nullable = true)
    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }
    @Basic
    @Column(name = "maintenance_hour", nullable = true)
    public Double getMaintenanceHour() {
        return maintenanceHour;
    }

    public void setMaintenanceHour(Double maintenanceHour) {
        this.maintenanceHour = maintenanceHour;
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

    @OneToMany(mappedBy = "maintenancesByMaintenanceid")
    public Collection<MaintenancePartEntity> getMaintenancePartsByMaintenanceid() {
        return maintenancePartsByMaintenanceid;
    }

    public void setMaintenancePartsByMaintenanceid(Collection<MaintenancePartEntity> maintenancePartsByMaintenanceid) {
        this.maintenancePartsByMaintenanceid = maintenancePartsByMaintenanceid;
    }

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carid",insertable=false,updatable=false)
    public CarsEntity getCarsByCarid() {
        return carsByCarid;
    }

    public void setCarsByCarid(CarsEntity carsByCarid) {
        this.carsByCarid = carsByCarid;
    }

    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid",insertable=false,updatable=false)
    public EmployeesEntity getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(EmployeesEntity employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }
}
