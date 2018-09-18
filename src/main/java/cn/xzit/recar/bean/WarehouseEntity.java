package cn.xzit.recar.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "warehouse", schema = "recar", catalog = "")
public class WarehouseEntity {
    private int partid;
    private BigDecimal inPrice;
    private BigDecimal ourPrice;
    private Integer num;
    private String erorrMessage;

    @Id
    @Column(name = "partid")
    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "in_price")
    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    @Basic
    @Column(name = "our_price")
    public BigDecimal getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(BigDecimal ourPrice) {
        this.ourPrice = ourPrice;
    }

    @Basic
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "erorr_message")
    public String getErorrMessage() {
        return erorrMessage;
    }

    public void setErorrMessage(String erorrMessage) {
        this.erorrMessage = erorrMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return partid == that.partid &&
                Objects.equals(inPrice, that.inPrice) &&
                Objects.equals(ourPrice, that.ourPrice) &&
                Objects.equals(num, that.num) &&
                Objects.equals(erorrMessage, that.erorrMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partid, inPrice, ourPrice, num, erorrMessage);
    }
}
