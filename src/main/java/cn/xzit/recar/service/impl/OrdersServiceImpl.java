package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.CarsJpa;
import cn.xzit.recar.Jpa.OrdersJpa;
import cn.xzit.recar.bean.domain.OrderDto;
import cn.xzit.recar.service.OrdersService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl extends CommonService implements OrdersService {
    @Autowired
    private OrdersJpa ordersJpa;

    @Autowired
    private CarsJpa carsJpa;
    @Override
    public List<OrderDto> findAllDto() {
        return ordersJpa.findAllDto();
    }

    @Override
    public List<OrderDto> findDtoByCuId(int cuId) {
        List<Integer> carIds= carsJpa.findCarid(cuId);
        return  ordersJpa.findDtoByCuId(carIds);
    }

}
