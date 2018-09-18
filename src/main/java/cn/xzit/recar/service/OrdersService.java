package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.OrderDto;

import java.util.List;

public interface OrdersService {


    List<OrderDto> findAllDto();
    List<OrderDto> findDtoByCuId(int cuId);
}
