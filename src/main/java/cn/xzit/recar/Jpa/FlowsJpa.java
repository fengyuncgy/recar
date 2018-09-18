package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.FlowDto;
import cn.xzit.recar.bean.domain.FlowPartDto;
import cn.xzit.recar.bean.entity.FlowsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowsJpa extends BaseJpa<FlowsEntity> {


    @Query("select new cn.xzit.recar.bean.domain.FlowPartDto(f.flowid,f.flowTime,f.message,f.employeeid,e.name,fp.fpid,p.partid,p.partName,fp.num) from FlowsEntity f " +
            "left join f.flowPartsByFlowid fp " +
            "left join f.employeesByEmployeeid e " +
            "left join fp.partsByPartid p ")
    List<FlowPartDto> list(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.FlowPartDto(f.flowid,f.flowTime,f.message,f.employeeid,e.name,fp.fpid,p.partid,p.partName,fp.num) from FlowsEntity f " +
            "left join f.flowPartsByFlowid fp " +
            "left join f.employeesByEmployeeid e " +
            "left join fp.partsByPartid p " +
            "where f.flowid = ?1 ")
    List<FlowPartDto> list(int flowId);




    @Query("select new cn.xzit.recar.bean.domain.FlowDto(f.flowid,f.flowTime,f.message,f.employeeid,e.name) from FlowsEntity f " +
            "left join f.employeesByEmployeeid e ")
    List<FlowDto> list1(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.FlowDto(f.flowid,f.flowTime,f.message,f.employeeid,e.name) from FlowsEntity f " +
            "left join f.employeesByEmployeeid e " +
            "where f.flowid = ?1 ")
    List<FlowDto> list1(int flowId);
}
