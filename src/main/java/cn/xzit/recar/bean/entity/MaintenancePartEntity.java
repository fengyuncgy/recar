package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "maintenance_part", schema = "recar", catalog = "")
public class MaintenancePartEntity {
    private int maintenancePartid;
    private Integer partid;
    private Integer maintenanceid;
    private Integer num;
    private PartsEntity partsByPartid;
    private MaintenancesEntity maintenancesByMaintenanceid;

    @Id
    @Column(name = "maintenance_partid", nullable = false)
    public int getMaintenancePartid() {
        return maintenancePartid;
    }

    public void setMaintenancePartid(int maintenancePartid) {
        this.maintenancePartid = maintenancePartid;
    }

    @Basic
    @Column(name = "partid", nullable = true)
    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "maintenanceid", nullable = true)
    public Integer getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(Integer maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenancePartEntity that = (MaintenancePartEntity) o;
        return maintenancePartid == that.maintenancePartid &&
                Objects.equals(partid, that.partid) &&
                Objects.equals(maintenanceid, that.maintenanceid) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {

        return Objects.hash(maintenancePartid, partid, maintenanceid, num);
    }

    @ManyToOne
    @JoinColumn(name = "partid", referencedColumnName = "partid",insertable=false,updatable=false)
    public PartsEntity getPartsByPartid() {
        return partsByPartid;
    }

    public void setPartsByPartid(PartsEntity partsByPartid) {
        this.partsByPartid = partsByPartid;
    }

    @ManyToOne
    @JoinColumn(name = "maintenanceid", referencedColumnName = "maintenanceid",insertable=false,updatable=false)
    public MaintenancesEntity getMaintenancesByMaintenanceid() {
        return maintenancesByMaintenanceid;
    }

    public void setMaintenancesByMaintenanceid(MaintenancesEntity maintenancesByMaintenanceid) {
        this.maintenancesByMaintenanceid = maintenancesByMaintenanceid;
    }
}
