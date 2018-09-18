package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.AppliesDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.AppliesEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.AppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/apply")
public class AppliesController extends BaseController {

    @Autowired
    private AppliesService appliesService;


    @RequestMapping("/save")
    public ResultModel<Object> addApply(@RequestBody AppliesEntity appliesEntity){
        boolean result = appliesService.addApplies(appliesEntity);
        if(result) return success("添加成功");
        else return error("添加失败");
    }
    @RequestMapping("/update")
    public ResultModel<Object> updateApply(AppliesEntity appliesEntity){
        boolean result = appliesService.updateApplies(appliesEntity);
        if(result) return success("修改成功");
        else return error("修改失败");
    }

    @RequestMapping("/delete")
    public ResultModel<Object> deleteApply(@RequestParam("applyid") List<Integer> ids){
        boolean result = false;
        try{
            result = appliesService.deleteApplies(ids);
        }catch (Exception e){}
        if(result) return success("删除成功");
        else return error("删除失败");
    }


    @RequestMapping("/get")
    public ResultModel<AppliesDto> findOne(@RequestParam("applyId")int id){
        return success(appliesService.findOne(id));
    }

    @RequestMapping("/list")
    public ResultModel<List<AppliesDto>> findAll(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<AppliesDto> list = appliesService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }


    @RequestMapping("/getOnes")
    public ResultModel<List<AppliesDto>> getOnes(@RequestParam("id") int id){
        List<AppliesDto> list = appliesService.getOnes(id);
        return success(list);
    }
    @RequestMapping("/updateStatus")
    public ResultModel<Object> updateStatus(@RequestBody AppliesEntity appliesEntity){
        boolean result = appliesService.updateStatus(appliesEntity);
        if(result) return success("修改成功");
        else return error("修改失败");
    }

}
