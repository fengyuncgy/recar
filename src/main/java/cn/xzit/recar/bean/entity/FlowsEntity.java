package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "flows", schema = "recar", catalog = "")
public class FlowsEntity {
    private int flowid;
    private Timestamp flowTime;
    private String message;
    private Integer employeeid;
    private Collection<FlowPartEntity> flowPartsByFlowid;
    private EmployeesEntity employeesByEmployeeid;

    @Id
    @Column(name = "flowid", nullable = false)
    public int getFlowid() {
        return flowid;
    }

    public void setFlowid(int flowid) {
        this.flowid = flowid;
    }

    @Basic
    @Column(name = "flow_time", nullable = true)
    public Timestamp getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(Timestamp flowTime) {
        this.flowTime = flowTime;
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

    @OneToMany(mappedBy = "flowsByFlowid",cascade = CascadeType.ALL)
    public Collection<FlowPartEntity> getFlowPartsByFlowid() {
        return flowPartsByFlowid;
    }

    public void setFlowPartsByFlowid(Collection<FlowPartEntity> flowPartsByFlowid) {
        this.flowPartsByFlowid = flowPartsByFlowid;
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
