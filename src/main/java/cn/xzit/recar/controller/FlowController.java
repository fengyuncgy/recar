package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.FlowDto;
import cn.xzit.recar.bean.domain.FlowPartDto;
import cn.xzit.recar.bean.entity.FlowPartEntity;
import cn.xzit.recar.bean.entity.FlowsEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.FlowService;
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
@RequestMapping("/flow")
public class FlowController extends BaseController {

    @Autowired
    private FlowService flowPartService;

    @RequestMapping("/list")
    public ResultModel<List<FlowPartDto>> list (Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber() - 1, p.getPageSize());
        CePage<FlowPartDto> list = flowPartService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }
    @RequestMapping("/list1")
    public ResultModel<List<FlowDto>> list1 (Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber() - 1, p.getPageSize());
        CePage<FlowDto> list = flowPartService.list1(pageable);
        return success(list.getContent(),list.getTotalElements());
    }
    @RequestMapping("/findByFlowId")
    public ResultModel<List<FlowPartDto>> findByFlowId (@RequestParam("id") int id){
        List<FlowPartDto> list = flowPartService.findByFlowId(id);
        return success(list);
    }

    @RequestMapping("/save")
    public ResultModel<Object> save(@RequestBody FlowsEntity flowsEntity){
        boolean b = flowPartService.save(flowsEntity);
        if(b) return success("添加成功");
        else return error("添加失败");
    }
    @RequestMapping("/saveFlowPartEntity")
    public ResultModel<Object> save(@RequestBody FlowPartEntity flowPartEntity){
        boolean b = flowPartService.save(flowPartEntity);
        if(b) return success("添加成功");
        else return error("添加失败");
    }

    @RequestMapping("/update")
    public ResultModel<Object> update(@RequestBody FlowsEntity flowsEntity){
        boolean b = flowPartService.save(flowsEntity);
        if(b) return success("修改成功");
        else return error("修改失败");
    }
    @RequestMapping("/updateFlowPartEntity")
    public ResultModel<Object> update(@RequestBody FlowPartEntity flowPartEntity){
        boolean b = flowPartService.save(flowPartEntity);
        if(b) return success("修改成功");
        else return error("修改失败");
    }
    @RequestMapping("/delete")
    public ResultModel<Object> delete(@RequestParam("flowid") List<Integer> ids){
        boolean b = flowPartService.delete(ids);
        if(b) return success("删除成功");
        else return error("删除失败");
    }
    @RequestMapping("/deleteFlowPartEntity")
    public ResultModel<Object> deleteFlowPartEntity(@RequestParam("ids") List<Integer> ids){
        boolean result = false;
        try{
            result = flowPartService.deletePart(ids);
        }catch (Exception e){}
        if(result) return success("删除成功");
        else return error("删除失败");
    }



    @RequestMapping("/getFlowid")
    public ResultModel<Object> getFlowid(HttpSession httpSession){
        Object flowid = httpSession.getAttribute("flowid");
        return success(flowid);
    }

}
