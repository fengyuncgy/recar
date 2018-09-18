package cn.xzit.recar.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "evaluates", schema = "recar", catalog = "")
public class EvaluatesEntity {
    private int evaluateid;
    private BigDecimal server;
    private BigDecimal maintenance;
    private Integer value;
    private Integer employeeid;

    @Id
    @Column(name = "evaluateid")
    public int getEvaluateid() {
        return evaluateid;
    }

    public void setEvaluateid(int evaluateid) {
        this.evaluateid = evaluateid;
    }

    @Basic
    @Column(name = "server")
    public BigDecimal getServer() {
        return server;
    }

    public void setServer(BigDecimal server) {
        this.server = server;
    }

    @Basic
    @Column(name = "maintenance")
    public BigDecimal getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(BigDecimal maintenance) {
        this.maintenance = maintenance;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        EvaluatesEntity that = (EvaluatesEntity) o;
        return evaluateid == that.evaluateid &&
                Objects.equals(server, that.server) &&
                Objects.equals(maintenance, that.maintenance) &&
                Objects.equals(value, that.value) &&
                Objects.equals(employeeid, that.employeeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evaluateid, server, maintenance, value, employeeid);
    }
}
