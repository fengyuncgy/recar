package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CarsDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.CarsEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarsController extends BaseController {

    @Autowired
    private CarsService carsService;

    @RequestMapping("/list")
    public ResultModel<List<CarsDto>> findAll(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<CarsDto> list = carsService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }
    @RequestMapping("/getOnes")
    public ResultModel<List<CarsDto>> getOnes(@RequestParam("id") int id){
        List<CarsDto> list = carsService.getOnes(id);
        return success(list);
    }
    @RequestMapping("/save")
    public ResultModel<Object> addCar(@RequestBody CarsEntity carsEntity){
        boolean result = carsService.addCars(carsEntity);
        if(result) return success("添加成功");
        else return error("添加失败");
    }

    @RequestMapping("/update")
    public ResultModel<Object> updateCar(@RequestBody CarsEntity carsEntity){
        boolean result = carsService.updateCars(carsEntity);
        if(result) return success("修改成功");
        else return error("修改失败");
    }

    @RequestMapping("/delete")
    public ResultModel<Object> deleteCar(@RequestParam("carid") List<Integer> ids){
        boolean result = false;
        try{
            result = carsService.deleteCars(ids);
        }catch (Exception e){}
        if(result)return success("删除成功");
        else return error("删除失败");
    }

    @RequestMapping("/get")
    public ResultModel<CarsDto> findOne(@RequestParam("carId") int id){
        return success(carsService.findOne(id));
    }
}
