package cn.xzit.recar.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flow_part", schema = "recar", catalog = "")
public class FlowPartEntity {
    private int fpid;
    private Integer partid;
    private Integer flowid;
    private Integer num;

    @Id
    @Column(name = "fpid")
    public int getFpid() {
        return fpid;
    }

    public void setFpid(int fpid) {
        this.fpid = fpid;
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
    @Column(name = "flowid")
    public Integer getFlowid() {
        return flowid;
    }

    public void setFlowid(Integer flowid) {
        this.flowid = flowid;
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
        FlowPartEntity that = (FlowPartEntity) o;
        return fpid == that.fpid &&
                Objects.equals(partid, that.partid) &&
                Objects.equals(flowid, that.flowid) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fpid, partid, flowid, num);
    }
}
