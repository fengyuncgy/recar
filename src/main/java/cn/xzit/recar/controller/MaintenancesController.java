package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancePartDto;
import cn.xzit.recar.bean.domain.MaintenancesDto;
import cn.xzit.recar.bean.entity.MaintenancesEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.MaintenancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/maintenance")
public class MaintenancesController extends BaseController {

    @Autowired
    private MaintenancesService maintenancesService;


    @RequestMapping("/save")
    public ResultModel<Object> addMaintenance(@RequestBody MaintenancesEntity maintenancesEntity){
        boolean b = false;
        try {
            b = maintenancesService.addMaintenance(maintenancesEntity);
        } catch (Exception e) {
            
        }
        if(b) return success("添加成功");
        else return error("添加失败");
    }
    @RequestMapping("/exist")
    public ResultModel<Object> findOne(@RequestParam("carid") int carId,@RequestParam("orderid") int orderId){
        boolean b = maintenancesService.findOne(carId,orderId);
        if(b) return success("1");
        else return error("2");
    }
    @RequestMapping("/list")
    public ResultModel<List<MaintenancesDto>> list(Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber() - 1, p.getPageSize());
        CePage<MaintenancesDto> maintenancesDtoCePage = maintenancesService.list(pageable);
        return success(maintenancesDtoCePage.getContent(), maintenancesDtoCePage.getTotalElements());
    }

    @RequestMapping("/findByEmployeeid")
    public ResultModel<List<MaintenancesDto>> findByEmployeeId(@RequestParam("id") int id) {
        List<MaintenancesDto> all = maintenancesService.findByEmployeeId(id);
        return success(all);
    }
    @RequestMapping("/findOne")
    public ResultModel<MaintenancesDto> findByCarid(@RequestParam("id")int id) {
        MaintenancesDto all = maintenancesService.findOne(id);
        return success(all);
    }


    @RequestMapping("/findByCarid")
    public ResultModel<List<MaintenancesDto>> findByCarid(@RequestParam("id") List<Integer> id) {
        List<MaintenancesDto> all = maintenancesService.findByCarId(id);
        return success(all);
    }
    @RequestMapping("/delete")
    public ResultModel<Object> addMaintenance(@RequestParam("id") List<Integer> ids){
        boolean b = false;
        try {
            b = maintenancesService.deleteMaintenance(ids);
        } catch (Exception e) {
            
        }
        if(b) return success("删除成功");
        else return error("删除失败");
    }
    @RequestMapping("/updateEmployeeid")
    public ResultModel<Object> updateEmployeeid(@RequestBody MaintenancesEntity maintenancesEntity){
        boolean b = maintenancesService.updateEmployeeid(maintenancesEntity);
        if(b) return success("分配成功");
        else return error("分配失败");
    }

    @RequestMapping("updateStatus")
    public ResultModel<Object> updateStatus(@RequestBody MaintenancesEntity maintenancesEntity){
        boolean result = false;
        try {
            result = maintenancesService.updateStatus(maintenancesEntity);
        } catch (Exception e) {
            
        }
        if(result) return success("修改成功");
        else return  error("修改失败");
    }
    @RequestMapping("findDtoByCustomerId")
    public ResultModel<List<MaintenancesDto>> findDtoByCustomerId(@RequestParam("id") int id){
        List<MaintenancesDto> all = maintenancesService.findDtoByCustomerId(id);
        return success(all);
    }
}
