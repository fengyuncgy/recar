package cn.xzit.recar.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "recar", catalog = "")
public class EmployeesEntity {
    private int employeeid;
    private String name;
    private String account;
    private String password;
    private Integer sex;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日")
    private Date birth;
    private String address;
    private String tel;
    private Integer type;
    private Integer status;
    private Collection<DetectionsEntity> detectionsByEmployeeid;
    private Collection<EvaluatesEntity> evaluatesByEmployeeid;
    private Collection<FlowsEntity> flowsByEmployeeid;
    private Collection<MaintenancesEntity> maintenancesByEmployeeid;
    private SalaryEntity salaryByEmployeeid;

    @Id
    @Column(name = "employeeid", nullable = false)
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "account", nullable = true, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birth", nullable = true)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 11)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return employeeid == that.employeeid &&
                Objects.equals(name, that.name) &&
                Objects.equals(account, that.account) &&
                Objects.equals(password, that.password) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(birth, that.birth) &&
                Objects.equals(address, that.address) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(type, that.type) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeid, name, account, password, sex, birth, address, tel, type, status);
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<DetectionsEntity> getDetectionsByEmployeeid() {
        return detectionsByEmployeeid;
    }

    public void setDetectionsByEmployeeid(Collection<DetectionsEntity> detectionsByEmployeeid) {
        this.detectionsByEmployeeid = detectionsByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<EvaluatesEntity> getEvaluatesByEmployeeid() {
        return evaluatesByEmployeeid;
    }

    public void setEvaluatesByEmployeeid(Collection<EvaluatesEntity> evaluatesByEmployeeid) {
        this.evaluatesByEmployeeid = evaluatesByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<FlowsEntity> getFlowsByEmployeeid() {
        return flowsByEmployeeid;
    }

    public void setFlowsByEmployeeid(Collection<FlowsEntity> flowsByEmployeeid) {
        this.flowsByEmployeeid = flowsByEmployeeid;
    }

    @OneToMany(mappedBy = "employeesByEmployeeid")
    public Collection<MaintenancesEntity> getMaintenancesByEmployeeid() {
        return maintenancesByEmployeeid;
    }

    public void setMaintenancesByEmployeeid(Collection<MaintenancesEntity> maintenancesByEmployeeid) {
        this.maintenancesByEmployeeid = maintenancesByEmployeeid;
    }

    @OneToOne(mappedBy = "employeesByEmployeeid",cascade = CascadeType.ALL  )
    public SalaryEntity getSalaryByEmployeeid() {
        return salaryByEmployeeid;
    }

    public void setSalaryByEmployeeid(SalaryEntity salaryByEmployeeid) {
        this.salaryByEmployeeid = salaryByEmployeeid;
    }
}
