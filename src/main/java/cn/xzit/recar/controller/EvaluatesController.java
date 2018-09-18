package cn.xzit.recar.controller;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EvaluatesDto;
import cn.xzit.recar.bean.entity.EvaluatesEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.EvaluatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evaluate")
public class EvaluatesController extends BaseController {
    @Autowired
    private EvaluatesService evaluatesService;
    @RequestMapping("/list")
    public ResultModel<List<EvaluatesDto>> list(Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber()-1,p.getPageSize());
        CePage<EvaluatesDto> list = evaluatesService.list(pageable);
        return success(list.getContent(),list.getTotalElements());
    }

    @RequestMapping("/findByEvaluateid")
    public ResultModel<List<EvaluatesDto>> findByEvaluateid(@RequestParam("id") int  id){
        List<EvaluatesDto> list = evaluatesService.findByEvaluateid(id);
        return success(list);
    }

    @RequestMapping("/findByCarid")
    public ResultModel<List<EvaluatesDto>> findByCarid(@RequestParam("id") List<Integer>  id){
        List<EvaluatesDto> list = evaluatesService.findByCarid(id);
        return success(list);
    }

    @RequestMapping("updateEvaluate")
    public ResultModel<Object> updateEvaluate(@RequestBody EvaluatesEntity evaluatesEntity){
        boolean result = false;
        try {
            result = evaluatesService.updateEvaluate(evaluatesEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result)return success("评价成功");
        else return error("评价失败");
    }
    @RequestMapping("delete")
    public ResultModel<Object> delete(@RequestParam("ids") List<Integer> ids){
        boolean result = false;
        try {
            result = evaluatesService.deleteEvaluate(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result)return success("评价成功");
        else return error("评价失败");
    }
}
