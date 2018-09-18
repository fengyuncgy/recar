package cn.xzit.recar.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "maintenance_part", schema = "recar", catalog = "")
public class MaintenancePartEntity {
    private int maintenancePartid;
    private Integer partid;
    private Integer maintenanceid;
    private Integer num;

    @Id
    @Column(name = "maintenance_partid")
    public int getMaintenancePartid() {
        return maintenancePartid;
    }

    public void setMaintenancePartid(int maintenancePartid) {
        this.maintenancePartid = maintenancePartid;
    }

    @Basic
    @Column(name = "partid")
    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "maintenanceid")
    public Integer getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(Integer maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    @Basic
    @Column(name = "num")
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
}
