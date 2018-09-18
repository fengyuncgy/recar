package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "warehouse", schema = "recar", catalog = "")
public class WarehouseEntity {
    private int partid;
    private Integer inPrice;
    private Integer ourPrice;
    private Integer num;
    private String erorrMessage;
    private String place;
    private PartsEntity partsByPartid;

    @Id
    @Column(name = "partid", nullable = false)
    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    @Basic
    @Column(name = "in_price", nullable = true, precision = 0)
    public Integer getInPrice() {
        return inPrice;
    }

    public void setInPrice(Integer inPrice) {
        this.inPrice = inPrice;
    }

    @Basic
    @Column(name = "our_price", nullable = true, precision = 0)
    public Integer getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(Integer ourPrice) {
        this.ourPrice = ourPrice;
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "erorr_message", nullable = true, length = 100)
    public String getErorrMessage() {
        return erorrMessage;
    }

    public void setErorrMessage(String erorrMessage) {
        this.erorrMessage = erorrMessage;
    }
    @Basic
    @Column(name = "place", nullable = true, length = 100)
    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
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
                Objects.equals(erorrMessage, that.erorrMessage) &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {

        return Objects.hash(partid, inPrice, ourPrice, num, erorrMessage, place);
    }

    @OneToOne
    @JoinColumn(name = "partid", referencedColumnName = "partid", nullable = false)
    public PartsEntity getPartsByPartid() {
        return partsByPartid;
    }

    public void setPartsByPartid(PartsEntity partsByPartid) {
        this.partsByPartid = partsByPartid;
    }
}
