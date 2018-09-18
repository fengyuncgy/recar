package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.CustomerDto;
import cn.xzit.recar.bean.model.CustomerModel;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController extends BaseController {

    @Autowired
    private CustomerService customerService;
    @RequestMapping("/list")
    public ResultModel<List<CustomerDto>> findAll(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<CustomerDto> all = customerService.findAll(pageable);
        return  success(all.getContent(),all.getTotalElements());
    }
    @RequestMapping("/findOne")
    public CustomerDto findOne(@RequestParam("id") int id){
        return  customerService.findOne(id);
    }

    @RequestMapping("/updatePassword")
    public ResultModel<Object>  updatePassword(@RequestParam("id") int id,@RequestParam("old") String oldPassword,@RequestParam("new") String newPassword){
        boolean result = false;
        try {
            result= customerService.updatePassword(id,oldPassword,newPassword);
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("修改成功");
        else return error("修改失败");
    }
    @RequestMapping("/delete")
    public ResultModel<Object> deleteCustomer(@RequestParam("customerid") List<Integer> ids){
        boolean result = false;
        try {
           result= customerService.deleteCustomer(ids);
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("删除成功");
        else return error("删除失败");
    }

    @RequestMapping("/save")
    public ResultModel<Object> insertCustomer(@RequestBody CustomerModel customerModel){
        boolean result = false;
        try {
            result= customerService.insertCustomer(customerModel);
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("注册成功");
        else return error("注册失败");
    }


    @RequestMapping("/update")
    public ResultModel<Object> updateCustomer(@RequestBody CustomerModel customerModel){
        boolean result = false;
        try {
            result= customerService.updateCustomer(customerModel)==0;
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("修改成功");
        else return error("修改失败");
    }
}
