package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancePartDto;
import cn.xzit.recar.bean.entity.MaintenancePartEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.MaintenancePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/maintenancePart")
public class MaintenancePartController extends BaseController {

    @Autowired
    private MaintenancePartService maintenancePartService;


    @RequestMapping("/list")
    public ResultModel<List<MaintenancePartDto>> list(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber() - 1, p.getPageSize());
        CePage<MaintenancePartDto> maintenancesDtoCePage = maintenancePartService.list(pageable);
        return success(maintenancesDtoCePage.getContent(), maintenancesDtoCePage.getTotalElements());
    }

    @RequestMapping("/findByMaintenanceid")
    public ResultModel<List<MaintenancePartDto>> findByMaintenanceid(@RequestParam("id") int id){
        List<MaintenancePartDto> list = maintenancePartService.findByMaintenanceid(id);
        return success(list);
    }

    @RequestMapping("/getMaintenanceid")
    public ResultModel<Object> getMaintenanceid(HttpSession httpSession){
        Object maintenanceid = httpSession.getAttribute("maintenanceid");
        return success(maintenanceid);
    }


    @RequestMapping("/save")
    public ResultModel<Object> save(@RequestBody MaintenancePartEntity maintenancePartEntity){

        boolean save = maintenancePartService.save(maintenancePartEntity);
        if(save)
            return success("保存成功");
        else return error("保存失败");

    }

    @RequestMapping("/update")
    public ResultModel<Object> update(@RequestBody MaintenancePartEntity maintenancePartEntity){

        boolean save = maintenancePartService.update(maintenancePartEntity);
        if(save)
            return success("修改成功");
        else return error("修改失败");

    }
    @RequestMapping("/delete")
    public ResultModel<Object> delete(@RequestParam("id") List<Integer> ids){

        boolean save = maintenancePartService.delete(ids);
        if(save)
            return success("删除成功");
        else return error("删除失败");

    }
}
