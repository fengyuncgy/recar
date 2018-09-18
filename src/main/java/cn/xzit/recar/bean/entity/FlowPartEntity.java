package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flow_part", schema = "recar", catalog = "")
public class FlowPartEntity {
    private int fpid;
    private Integer partid;
    private Integer flowid;
    private Integer num;
    private PartsEntity partsByPartid;
    private FlowsEntity flowsByFlowid;

    @Id
    @Column(name = "fpid", nullable = false)
    public int getFpid() {
        return fpid;
    }

    public void setFpid(int fpid) {
        this.fpid = fpid;
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
    @Column(name = "flowid", nullable = true)
    public Integer getFlowid() {
        return flowid;
    }

    public void setFlowid(Integer flowid) {
        this.flowid = flowid;
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

    @ManyToOne
    @JoinColumn(name = "partid", referencedColumnName = "partid",insertable=false,updatable=false)
    public PartsEntity getPartsByPartid() {
        return partsByPartid;
    }

    public void setPartsByPartid(PartsEntity partsByPartid) {
        this.partsByPartid = partsByPartid;
    }

    @ManyToOne
    @JoinColumn(name = "flowid", referencedColumnName = "flowid",insertable=false,updatable=false)
    public FlowsEntity getFlowsByFlowid() {
        return flowsByFlowid;
    }

    public void setFlowsByFlowid(FlowsEntity flowsByFlowid) {
        this.flowsByFlowid = flowsByFlowid;
    }
}
