package cn.xzit.recar.bean.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "evaluates", schema = "recar", catalog = "")
public class EvaluatesEntity {
    private int evaluateid;
    private Integer server;
    private Integer maintenance;
    private Integer value;
    private Integer status;
    private Integer employeeid;
    private OrdersEntity ordersByEvaluateid;
    private EmployeesEntity employeesByEmployeeid;

    @Id
    @Column(name = "evaluateid", nullable = false)
    public int getEvaluateid() {
        return evaluateid;
    }

    public void setEvaluateid(int evaluateid) {
        this.evaluateid = evaluateid;
    }

    @Basic
    @Column(name = "server", nullable = true, precision = 0)
    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    @Basic
    @Column(name = "maintenance", nullable = true, precision = 0)
    public Integer getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Integer maintenance) {
        this.maintenance = maintenance;
    }

    @Basic
    @Column(name = "value", nullable = true, precision = 0)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        EvaluatesEntity that = (EvaluatesEntity) o;
        return evaluateid == that.evaluateid &&
                Objects.equals(server, that.server) &&
                Objects.equals(maintenance, that.maintenance) &&
                Objects.equals(value, that.value) &&
                Objects.equals(status, that.status) &&
                Objects.equals(employeeid, that.employeeid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(evaluateid, server, maintenance, value, status, employeeid);
    }

    @OneToOne
    @JoinColumn(name = "evaluateid", referencedColumnName = "orderid", nullable = false)
    public OrdersEntity getOrdersByEvaluateid() {
        return ordersByEvaluateid;
    }

    public void setOrdersByEvaluateid(OrdersEntity ordersByEvaluateid) {
        this.ordersByEvaluateid = ordersByEvaluateid;
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
