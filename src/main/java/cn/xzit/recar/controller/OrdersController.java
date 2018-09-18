package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.OrderDto;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrdersController extends BaseController{

    @Autowired
    private OrdersService ordersService ;
    @RequestMapping("findAll")
    public ResultModel<List<OrderDto>> findAll(){
        return success(ordersService.findAllDto());
    }
    @RequestMapping("findByCustomerId")
    public ResultModel<List<OrderDto>> findByCustomerId(int id){
        return success(ordersService.findDtoByCuId(id));
    }
}
