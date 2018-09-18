package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.entity.FlowPartEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowPartJpa extends BaseJpa<FlowPartEntity> {

    @Query("select f.fpid from FlowPartEntity f where f.flowid =?1 and f.partid=?2")
    Integer findByFlowidAndPartid(int flowid ,int partid);

}
