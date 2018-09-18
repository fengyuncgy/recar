package cn.xzit.recar.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "flows", schema = "recar", catalog = "")
public class FlowsEntity {
    private int flowid;
    private Timestamp flowTime;
    private String message;
    private Integer employeeid;

    @Id
    @Column(name = "flowid")
    public int getFlowid() {
        return flowid;
    }

    public void setFlowid(int flowid) {
        this.flowid = flowid;
    }

    @Basic
    @Column(name = "flow_time")
    public Timestamp getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(Timestamp flowTime) {
        this.flowTime = flowTime;
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
        FlowsEntity that = (FlowsEntity) o;
        return flowid == that.flowid &&
                Objects.equals(flowTime, that.flowTime) &&
                Objects.equals(message, that.message) &&
                Objects.equals(employeeid, that.employeeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowid, flowTime, message, employeeid);
    }
}
