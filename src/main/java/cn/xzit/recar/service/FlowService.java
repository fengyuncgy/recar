package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.FlowDto;
import cn.xzit.recar.bean.domain.FlowPartDto;
import cn.xzit.recar.bean.entity.FlowPartEntity;
import cn.xzit.recar.bean.entity.FlowsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlowService {

    CePage<FlowPartDto> list(Pageable pageable);

    boolean save(FlowsEntity flowsEntity);
    boolean save(FlowPartEntity flowPartEntity);
    boolean update(FlowPartEntity flowPartEntity);

    boolean delete(List<Integer> ids);
    boolean deletePart(List<Integer> ids);
    CePage<FlowDto> list1(Pageable pageable);
    List<FlowPartDto> findByFlowId(int id);
}
