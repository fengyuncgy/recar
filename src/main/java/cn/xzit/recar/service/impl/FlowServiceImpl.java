package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.FlowPartJpa;
import cn.xzit.recar.Jpa.FlowsJpa;
import cn.xzit.recar.Jpa.WarehouseJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.FlowDto;
import cn.xzit.recar.bean.domain.FlowPartDto;
import cn.xzit.recar.bean.entity.FlowPartEntity;
import cn.xzit.recar.bean.entity.FlowsEntity;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import cn.xzit.recar.service.FlowService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FlowServiceImpl extends CommonService implements FlowService {


    @Autowired
    private FlowsJpa flowsJpa;

    @Autowired
    private FlowPartJpa flowPartJpa;
    @Autowired
    private WarehouseJpa warehouseJpa;
    @Override
    public CePage<FlowPartDto> list(Pageable pageable) {
        return page(flowsJpa.list(pageable),pageable,flowsJpa.count());
    }

    @Override
    public boolean save(FlowsEntity flowsEntity) {
        flowsJpa.save(flowsEntity);
        return true;
    }

    @Override
    public boolean save(FlowPartEntity flowPartEntity) {
        Integer byFlowidAndPartid = flowPartJpa.findByFlowidAndPartid(flowPartEntity.getFlowid(), flowPartEntity.getPartid());
        if(byFlowidAndPartid==null)
            flowPartJpa.save(flowPartEntity);
        else {
            FlowPartEntity one = flowPartJpa.getOne(byFlowidAndPartid);
            one.setNum(one.getNum()+flowPartEntity.getNum());
            flowPartJpa.save(one);
        }
        WarehouseEntity one = warehouseJpa.getOne(flowPartEntity.getPartid());
        one.setNum(one.getNum()+flowPartEntity.getNum());
        warehouseJpa.save(one);
        return true;
    }

    @Override
    public boolean update(FlowPartEntity flowPartEntity) {
        flowPartJpa.save(flowPartEntity);
        FlowPartEntity one = flowPartJpa.getOne(flowPartEntity.getFpid());
        int num = flowPartEntity.getNum()-one.getNum();
        WarehouseEntity w = warehouseJpa.getOne(flowPartEntity.getPartid());
        w.setNum(w.getNum()+num);
        warehouseJpa.save(w);
        return true;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        List<FlowsEntity> flowsEntities = new ArrayList<>();
        ids.forEach(id->{
            FlowsEntity flowsEntity = new FlowsEntity();
            flowsEntity.setFlowid(id);
            flowsEntities.add(flowsEntity);
        });
        flowsJpa.deleteAll(flowsEntities);
        return true;
    }

    @Override
    public boolean deletePart(List<Integer> ids) {
        List<FlowPartEntity> flowPartEntities = new ArrayList<>();
        ids.forEach(id->{
            FlowPartEntity flowPartEntity = new FlowPartEntity();
            flowPartEntity.setFpid(id);
            flowPartEntities.add(flowPartEntity);
            FlowPartEntity one2 = flowPartJpa.getOne(flowPartEntity.getFpid());
            WarehouseEntity one = warehouseJpa.getOne(one2.getPartid());
            if(one!=null) {
                one.setNum(one.getNum() - one2.getNum());
                warehouseJpa.save(one);
            }
        });
        flowPartJpa.deleteAll(flowPartEntities);
        return true;
    }

    @Override
    public CePage<FlowDto> list1(Pageable pageable) {
        return page(flowsJpa.list1(pageable),pageable,flowsJpa.count());
    }

    @Override
    public List<FlowPartDto> findByFlowId(int id) {
        return flowsJpa.list(id);
    }
}
