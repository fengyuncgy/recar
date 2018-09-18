package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "salary", schema = "recar", catalog = "")
public class SalaryEntity {
    private int employeeid;
    private Double baseSalary;
    private Double addSalary;
    private Double finishCount;
    private Double monthCount;
    private Double hours;
    private Double addProportion;
    private EmployeesEntity employeesByEmployeeid;

    @Id
    @Column(name = "employeeid", nullable = false)
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "base_salary", nullable = true, precision = 0)
    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Basic
    @Column(name = "add_salary", nullable = true, precision = 0)
    public Double getAddSalary() {
        return addSalary;
    }

    public void setAddSalary(Double addSalary) {
        this.addSalary = addSalary;
    }

    @Basic
    @Column(name = "finish_count", nullable = true)
    public Double getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Double finishCount) {
        this.finishCount = finishCount;
    }

    @Basic
    @Column(name = "month_count", nullable = true)
    public Double getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Double monthCount) {
        this.monthCount = monthCount;
    }

    @Basic
    @Column(name = "add_proportion", nullable = true)
    public Double getAddProportion() {
        return addProportion;
    }


    public void setAddProportion(Double addProportion) {
        this.addProportion = addProportion;
    }

    @Basic
    @Column(name = "hours", nullable = true)
    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
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
                Objects.equals(hours, that.hours) &&
                Objects.equals(addProportion, that.addProportion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeid, baseSalary, addSalary, finishCount, monthCount, hours, addProportion);
    }

    @OneToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid", nullable = false)
    public EmployeesEntity getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(EmployeesEntity employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }
}
