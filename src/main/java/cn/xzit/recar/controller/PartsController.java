package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartsDto;
import cn.xzit.recar.bean.entity.PartsEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/part")
public class PartsController extends BaseController {

    @Autowired
    private PartsService partsService;


    @RequestMapping("/save")
    public ResultModel<Object> addPart(@RequestBody PartsEntity partsEntity){
        boolean b = false;
        try {
            b = partsService.addPart(partsEntity);
        } catch (Exception e) {

        }
        if (b)
            return success("添加成功");
        else return error("添加失败");
    }
    @RequestMapping("/update")
    public ResultModel<Object> update(@RequestBody PartsEntity partsEntity){
        boolean b = partsService.updatePart(partsEntity);
        if (b)
            return success("添加成功");
        else return error("添加失败");
    }


    @RequestMapping("/list")
    public ResultModel<List<PartsDto>> list(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<PartsDto> all = partsService.list(pageable);
        return  success( all.getContent(),all.getTotalElements());
    }

    @RequestMapping("/findAll")
    public ResultModel<List<PartsDto>> list(){
        List<PartsDto> all = partsService.findAll();
        return  success( all);
    }
    @RequestMapping("/findAllByGroupId")
    public ResultModel<List<PartsDto>> findAllByGroupId(int id){
        List<PartsDto> all = partsService.findAllByGroupId(id);
        return  success( all);
    }

    @RequestMapping("/delete")
    public ResultModel<Object> delete(@RequestParam("ids") List<Integer> ids){
        boolean b=false;
        try {
            b = partsService.deletePart(ids);
        }catch (Exception e){ }
        if (b)
            return success("删除成功 ");
        else return error("删除失败");
    }

}
