package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.WarehouseDto;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController extends BaseController {

    @Autowired
    private WarehouseService warehouseService;
    @RequestMapping("/list")
    public ResultModel<List<WarehouseDto>> list(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<WarehouseDto> list = warehouseService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }

    @RequestMapping("update")
    public ResultModel<Object> update(@RequestBody WarehouseEntity warehouseEntity){
        boolean result = false;
        try {
            result = warehouseService.updatePrice(warehouseEntity);
        } catch (Exception e) {

        }
        if(result)
            return success("修改售价成功");
        else return error("修改售价失败");
    }


    @RequestMapping("delete")
    public ResultModel<Object> delete(@RequestParam("ids") List<Integer> ids){
        boolean result = false;
        try {
            result = warehouseService.deleteWarehouse(ids);
        } catch (Exception e) {

        }
        if(result)
            return success("删除成功");
        else return error("删除失败");
    }

}
