package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "detections", schema = "recar", catalog = "")
public class DetectionsEntity {
    private int detectionid;
    private String detectionName;
    private Timestamp detectionTime;
    private Integer detectionStatus;
    private String message;
    private Integer carid;
    private Integer employeeid;
    private CarsEntity carsByCarid;
    private EmployeesEntity employeesByEmployeeid;

    @Id
    @Column(name = "detectionid", nullable = false)
    public int getDetectionid() {
        return detectionid;
    }

    public void setDetectionid(int detectionid) {
        this.detectionid = detectionid;
    }

    @Basic
    @Column(name = "detection_name", nullable = true, length = 40)
    public String getDetectionName() {
        return detectionName;
    }

    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName;
    }

    @Basic
    @Column(name = "detection_time", nullable = true)
    public Timestamp getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Timestamp detectionTime) {
        this.detectionTime = detectionTime;
    }

    @Basic
    @Column(name = "detection_status", nullable = true)
    public Integer getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(Integer detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 100)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetectionsEntity that = (DetectionsEntity) o;
        return detectionid == that.detectionid &&
                Objects.equals(detectionName, that.detectionName) &&
                Objects.equals(detectionTime, that.detectionTime) &&
                Objects.equals(detectionStatus, that.detectionStatus) &&
                Objects.equals(message, that.message) &&
                Objects.equals(carid, that.carid) &&
                Objects.equals(employeeid, that.employeeid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(detectionid, detectionName, detectionTime, detectionStatus, message, carid, employeeid);
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
