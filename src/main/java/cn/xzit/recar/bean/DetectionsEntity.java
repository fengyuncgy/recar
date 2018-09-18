package cn.xzit.recar.bean;

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

    @Id
    @Column(name = "detectionid")
    public int getDetectionid() {
        return detectionid;
    }

    public void setDetectionid(int detectionid) {
        this.detectionid = detectionid;
    }

    @Basic
    @Column(name = "detection_name")
    public String getDetectionName() {
        return detectionName;
    }

    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName;
    }

    @Basic
    @Column(name = "detection_time")
    public Timestamp getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Timestamp detectionTime) {
        this.detectionTime = detectionTime;
    }

    @Basic
    @Column(name = "detection_status")
    public Integer getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(Integer detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
