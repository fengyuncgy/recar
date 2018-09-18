package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.Query;

public interface OrderStatusJpa extends BaseJpa<OrderStatusEntity> {

    @Query("select max (os.orderStatusid) from OrderStatusEntity os")
    Integer maxId();
}
