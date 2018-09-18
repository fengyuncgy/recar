package cn.xzit.recar.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "part_groups", schema = "recar", catalog = "")
public class PartGroupsEntity {
    private int partGroupid;
    private String groupName;
    private Integer preid;

    @Id
    @Column(name = "part_groupid")
    public int getPartGroupid() {
        return partGroupid;
    }

    public void setPartGroupid(int partGroupid) {
        this.partGroupid = partGroupid;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "preid")
    public Integer getPreid() {
        return preid;
    }

    public void setPreid(Integer preid) {
        this.preid = preid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartGroupsEntity that = (PartGroupsEntity) o;
        return partGroupid == that.partGroupid &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(preid, that.preid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partGroupid, groupName, preid);
    }
}
