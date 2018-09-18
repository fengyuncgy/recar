package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.DetectionsDto;
import cn.xzit.recar.bean.entity.DetectionsEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.DetectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("detection")
public class DetectionsController extends BaseController {

    @Autowired
    private DetectionsService detectionsService;

    @RequestMapping("/list")
    public ResultModel<List<DetectionsDto>> list(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<DetectionsDto> list = detectionsService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }

    @RequestMapping("delete")
    public ResultModel<Object> deleteAll(@RequestParam("id") List<Integer> ids){
        boolean result = detectionsService.deleteDetection(ids);
        if(result) return success("删除成功");
        else return  error("删除失败");
    }
    @RequestMapping("updateStatus")
    public ResultModel<Object> updateStatus(@RequestBody DetectionsEntity detectionsEntity){
        boolean result = detectionsService.updateStatus(detectionsEntity);
        if(result) return success("修改成功");
        else return  error("修改失败");
    }
    @RequestMapping("update")
    public ResultModel<Object> update(@RequestBody DetectionsEntity detectionsEntity){
        boolean result = detectionsService.updateDetection(detectionsEntity);
        if(result) return success("修改成功");
        else return  error("修改失败");
    }

    @RequestMapping("findByEmployeeid")
    public ResultModel<List<DetectionsDto>> findByEmployeeid(@RequestParam("id") int id){
        List<DetectionsDto> employeeid = detectionsService.findByEmployeeid(id);
        return success(employeeid);
    }

    @RequestMapping("findByCarid")
    public ResultModel<List<DetectionsDto>> findByCarid(@RequestParam("id") List<Integer> id){
        List<DetectionsDto> employeeid = detectionsService.findByCarid(id);
        return success(employeeid);
    }
}
