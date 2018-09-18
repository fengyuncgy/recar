package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.ManufacturersDto;
import cn.xzit.recar.bean.entity.ManufacturersEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.ManufacturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturersController extends BaseController{


    @Autowired
    private ManufacturersService manufacturersService;
    @RequestMapping("/list")
    public ResultModel<List<ManufacturersDto>> list (Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<ManufacturersDto> all = manufacturersService.list(pageable);
        return success(all.getContent(), all.getTotalElements());
    }
    @RequestMapping("/findAll")
    public ResultModel<List<ManufacturersDto>> list (){
        List<ManufacturersDto> all = manufacturersService.findAll();
        return success(all);
    }
    @RequestMapping("/save")
    public ResultModel<Object> save (@RequestBody ManufacturersEntity manufacturersEntity){
        boolean result = false;
        try {
            result = manufacturersService.save(manufacturersEntity);
        } catch (Exception e) {

        }
        if(result) return success("添加成功");
        else return error("添加失败");
    }
    @RequestMapping("/update")
    public ResultModel<Object> update (@RequestBody ManufacturersEntity manufacturersEntity){
        boolean result = false;
        try {
            result = manufacturersService.update(manufacturersEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result) return success("修改成功");
        else return error("修改失败");
    }
    @RequestMapping("/delete")
    public ResultModel<Object> delete (@RequestParam("id") List<Integer> ids){
        boolean result = false;
        try {
            result = manufacturersService.delete(ids);
        } catch (Exception e) {

        }
        if(result) return success("删除成功");
        else return error("删除失败");
    }


}
