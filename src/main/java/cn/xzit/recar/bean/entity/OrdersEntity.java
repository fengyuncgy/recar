package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "recar", catalog = "")
public class OrdersEntity {
    private int orderid;
    private String orderNumber;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp changetime;
    private Double price;
    private Integer carid;
    private EvaluatesEntity evaluatesByOrderid;
    private Collection<OrderStatusEntity> orderStatusesByOrderid;
    private CarsEntity carsByCarid;

    @Id
    @Column(name = "orderid", nullable = false)
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "order_number", nullable = true, length = 14)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "start_time", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "changetime", nullable = true)
    public Timestamp getChangetime() {
        return changetime;
    }

    public void setChangetime(Timestamp changetime) {
        this.changetime = changetime;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "carid", nullable = true)
    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderid == that.orderid &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(name, that.name) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(changetime, that.changetime) &&
                Objects.equals(price, that.price) &&
                Objects.equals(carid, that.carid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderid, orderNumber, name, startTime, endTime, changetime, price, carid);
    }

    @OneToOne(mappedBy = "ordersByEvaluateid")
    public EvaluatesEntity getEvaluatesByOrderid() {
        return evaluatesByOrderid;
    }

    public void setEvaluatesByOrderid(EvaluatesEntity evaluatesByOrderid) {
        this.evaluatesByOrderid = evaluatesByOrderid;
    }

    @OneToMany(mappedBy = "ordersByOrderid",cascade = CascadeType.ALL)
    public Collection<OrderStatusEntity> getOrderStatusesByOrderid() {
        return orderStatusesByOrderid;
    }

    public void setOrderStatusesByOrderid(Collection<OrderStatusEntity> orderStatusesByOrderid) {
        this.orderStatusesByOrderid = orderStatusesByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carid",insertable=false,updatable=false)
    public CarsEntity getCarsByCarid() {
        return carsByCarid;
    }

    public void setCarsByCarid(CarsEntity carsByCarid) {
        this.carsByCarid = carsByCarid;
    }
}
