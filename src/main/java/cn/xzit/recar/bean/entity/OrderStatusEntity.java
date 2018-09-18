package cn.xzit.recar.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_status", schema = "recar", catalog = "")
public class OrderStatusEntity {
    private int orderStatusid;
    private Timestamp statusStartTime;
    private Timestamp statusEndTime;
    private Integer type;
    private String message;
    private Integer orderid;
    private OrdersEntity ordersByOrderid;

    @Id
    @Column(name = "order_statusid", nullable = false)
    public int getOrderStatusid() {
        return orderStatusid;
    }

    public void setOrderStatusid(int orderStatusid) {
        this.orderStatusid = orderStatusid;
    }

    @Basic
    @Column(name = "status_start_time", nullable = true)
    public Timestamp getStatusStartTime() {
        return statusStartTime;
    }

    public void setStatusStartTime(Timestamp statusStartTime) {
        this.statusStartTime = statusStartTime;
    }

    @Basic
    @Column(name = "status_end_time", nullable = true)
    public Timestamp getStatusEndTime() {
        return statusEndTime;
    }

    public void setStatusEndTime(Timestamp statusEndTime) {
        this.statusEndTime = statusEndTime;
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
    @Column(name = "message", nullable = true, length = 100)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "orderid", nullable = true)
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusEntity that = (OrderStatusEntity) o;
        return orderStatusid == that.orderStatusid &&
                Objects.equals(statusStartTime, that.statusStartTime) &&
                Objects.equals(statusEndTime, that.statusEndTime) &&
                Objects.equals(type, that.type) &&
                Objects.equals(message, that.message) &&
                Objects.equals(orderid, that.orderid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderStatusid, statusStartTime, statusEndTime, type, message, orderid);
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid",insertable=false,updatable=false)
    public OrdersEntity getOrdersByOrderid() {
        return ordersByOrderid;
    }

    public void setOrdersByOrderid(OrdersEntity ordersByOrderid) {
        this.ordersByOrderid = ordersByOrderid;
    }
}
