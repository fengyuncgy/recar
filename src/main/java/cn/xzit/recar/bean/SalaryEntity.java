package cn.xzit.recar.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "salary", schema = "recar", catalog = "")
public class SalaryEntity {
    private int employeeid;
    private BigDecimal baseSalary;
    private BigDecimal addSalary;
    private Integer finishCount;
    private Integer monthCount;
    private BigDecimal hours;

    @Id
    @Column(name = "employeeid")
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "base_salary")
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Basic
    @Column(name = "add_salary")
    public BigDecimal getAddSalary() {
        return addSalary;
    }

    public void setAddSalary(BigDecimal addSalary) {
        this.addSalary = addSalary;
    }

    @Basic
    @Column(name = "finish_count")
    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    @Basic
    @Column(name = "month_count")
    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    @Basic
    @Column(name = "hours")
    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryEntity that = (SalaryEntity) o;
        return employeeid == that.employeeid &&
                Objects.equals(baseSalary, that.baseSalary) &&
                Objects.equals(addSalary, that.addSalary) &&
                Objects.equals(finishCount, that.finishCount) &&
                Objects.equals(monthCount, that.monthCount) &&
                Objects.equals(hours, that.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeid, baseSalary, addSalary, finishCount, monthCount, hours);
    }
}
