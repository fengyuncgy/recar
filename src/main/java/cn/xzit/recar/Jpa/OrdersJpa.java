package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.OrderDto;
import cn.xzit.recar.bean.entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrdersJpa extends BaseJpa<OrdersEntity> {

    @Query("select max (os.orderid) from OrdersEntity os")
    Integer maxId();
    @Query("select max (os.startTime) from OrdersEntity os where os.carid=?1 and os.startTime<=?2")
    Date maxStartByCar(int carid,Date time);
    @Query("select o from OrdersEntity o " +
            "where o.carid = ?1 and o.endTime is null")
    OrdersEntity findOrders(int carid);

    @Query("select new cn.xzit.recar.bean.domain.OrderDto(o.orderid,o.orderNumber,o.name,o.startTime,o.endTime,o.price,max(os.orderStatusid),max(os.type),o.carid,c.brand) from OrdersEntity o " +
            "left join o.orderStatusesByOrderid os " +
            "left join o.carsByCarid c group by o.orderid order by o.orderNumber desc ")
    List<OrderDto> findAllDto();
    @Query("select new cn.xzit.recar.bean.domain.OrderDto(o.orderid,o.orderNumber,o.name,o.startTime,o.endTime,o.price,max(os.orderStatusid),max(os.type),o.carid,c.brand)  from OrdersEntity o " +
            "left join o.orderStatusesByOrderid os " +
            "left join o.carsByCarid c  group by o.orderid having o.carid in ?1 order by o.orderNumber desc ")
    List<OrderDto> findDtoByCuId(List<Integer> ids);
}
