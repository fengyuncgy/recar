package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EmployeesDto;
import cn.xzit.recar.bean.domain.SalaryDto;
import cn.xzit.recar.bean.entity.EmployeesEntity;
import cn.xzit.recar.bean.entity.SalaryEntity;
import cn.xzit.recar.bean.model.EmployeesModel;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController extends BaseController {

    @Autowired
    private EmployeesService employeesService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultModel<Object> insertEmployee(@RequestBody EmployeesModel employeesModel){
        boolean result = employeesService.insertEmployees(employeesModel);

        if(result)  return success("添加成功");
        else return error("添加失败，账号已存在");
    }


    @RequestMapping(value = "/update")
    public ResultModel<Object> updateEmployee(@RequestBody EmployeesModel employeesModel){
        boolean result = employeesService.updateEmployees(employeesModel);

        if(result)  return success("修改成功");
        else return error("修改失败");
    }
    @RequestMapping(value = "/delete")
    public ResultModel<Object> deleteEmployee(@RequestParam("employeeid") List<Integer> ids){
        boolean result = false;
        try{
            result = employeesService.deleteEmployees(ids);
        }catch (Exception e){}
        if(result)  return success("删除成功");
        else return error("删除失败");
    }
    @RequestMapping(value = "/get")
    public EmployeesDto getEmployee(@RequestParam("id") int id){
        EmployeesDto employeesEntity = employeesService.findOne(id);
        return employeesEntity;

    }
    @RequestMapping("/list")
    public ResultModel<List<EmployeesDto>> findAll(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<EmployeesDto> all = employeesService.findAllBySort(pageable);
        return  success( all.getContent(),all.getTotalElements());
    }

    @RequestMapping("/findAllEmployee")
    public ResultModel<List<EmployeesDto>> findAllEmployee(){
        List<EmployeesDto> all = employeesService.findAllEmployee();
        return  success( all);
    }
    @RequestMapping("/updatePassword")
    public ResultModel<Object>  updatePassword(@RequestParam("id") int id,@RequestParam("old") String oldPassword,@RequestParam("new") String newPassword){
        boolean result = false;
        try {
            result= employeesService.updatePassword(id,oldPassword,newPassword);
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("修改成功");
        else return error("修改失败");
    }


    @RequestMapping("findAllByAdmin")
    public ResultModel<List<EmployeesDto>> findAllByAdmin(){
        List<EmployeesDto> all = employeesService.findAllByAdmin();
        return  success( all);
    }


    @RequestMapping("findSalaryDtoByEmployeeid")
    public SalaryDto findSalarDtoByEmployeeid(@RequestParam("id") int employeeId){
        SalaryDto salarDtoByEmployeeid = employeesService.findSalarDtoByEmployeeid(employeeId);
        return salarDtoByEmployeeid;
    }

    @RequestMapping("listByName")
    public ResultModel<List<EmployeesDto>> findByName(Pageable p,String name){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<EmployeesDto> all = employeesService.findByName(pageable,name);
        return  success( all.getContent(),all.getTotalElements());
    }

    @RequestMapping("findSalaryDto")
    public ResultModel<List<SalaryDto>> findSalarDto(){
        List<SalaryDto> salarDtoByEmployeeid = employeesService.findSalaryDto();
        return  success( salarDtoByEmployeeid);
    }
    @RequestMapping("updateSalary")
    public ResultModel<Object> updateSalary(@RequestBody SalaryEntity salaryEntity){
        boolean result = false;
        try {
            result= employeesService.updateSalary(salaryEntity);
        }catch (Exception e){
            result =false;
        }
        if(result)
            return success("维修工人工资设定成功");
        else return error("操作失败");
    }
}
