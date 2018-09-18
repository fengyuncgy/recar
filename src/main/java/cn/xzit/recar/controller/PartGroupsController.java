package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartGroupDto;
import cn.xzit.recar.bean.entity.PartGroupsEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.PartGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partGroup")
public class PartGroupsController extends BaseController{

    @Autowired
    private PartGroupsService partGroupsService;

    @RequestMapping("/list")
    public ResultModel<List<PartGroupDto>> findAll(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<PartGroupDto> list = partGroupsService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }

    @RequestMapping("/findAll")
    public ResultModel<List<PartGroupDto>> findAll(){
        List<PartGroupDto> list = partGroupsService.findAll();
        return success(list);
    }

    @RequestMapping("/save")
    public ResultModel<Object> save(@RequestBody PartGroupsEntity partGroupsEntity){
        boolean result = false;
        try {
            result = partGroupsService.addPartGroups(partGroupsEntity);
        } catch (Exception e) {

        }
        if(result) return success("添加成功");
        else return error("添加失败");
    }


    @RequestMapping("/update")
    public ResultModel<Object> update(@RequestBody PartGroupsEntity partGroupsEntity){
        boolean result = false;
        try {
            result = partGroupsService.updatePartGroups(partGroupsEntity);
        } catch (Exception e) {

        }
        if(result) return success("修改成功");
        else return error("修改失败");
    }

    @RequestMapping("/delete")
    public ResultModel<Object> delete(@RequestParam("id") List<Integer> ids){
        boolean result = false;
        try {
            result = partGroupsService.deletePartGroups(ids);
        } catch (Exception e) {

        }
        if(result) return success("删除成功");
        else return error("删除失败");
    }
}
