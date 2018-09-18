package cn.xzit.recar.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parts", schema = "recar", catalog = "")
public class PartsEntity {
    private int partid;
    private String partName;
    private String specification;
    private Integer partGroupid;
    private Integer manufacturerid;

    @Id
    @Column(name = "partid")
    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "part_name")
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Basic
    @Column(name = "specification")
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "part_groupid")
    public Integer getPartGroupid() {
        return partGroupid;
    }

    public void setPartGroupid(Integer partGroupid) {
        this.partGroupid = partGroupid;
    }

    @Basic
    @Column(name = "manufacturerid")
    public Integer getManufacturerid() {
        return manufacturerid;
    }

    public void setManufacturerid(Integer manufacturerid) {
        this.manufacturerid = manufacturerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsEntity that = (PartsEntity) o;
        return partid == that.partid &&
                Objects.equals(partName, that.partName) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(partGroupid, that.partGroupid) &&
                Objects.equals(manufacturerid, that.manufacturerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partid, partName, specification, partGroupid, manufacturerid);
    }
}
