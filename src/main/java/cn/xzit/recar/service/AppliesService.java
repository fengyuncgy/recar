package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.AppliesDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.AppliesEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppliesService {

    boolean addApplies(AppliesEntity appliesEntity);

    boolean updateApplies(AppliesEntity appliesEntity);

    boolean deleteApplies(List<Integer> ids);


    CePage<AppliesDto> list(Pageable pageable);

    List<AppliesDto> getOnes(int id);

    AppliesDto findOne(int id);

    boolean updateStatus(AppliesEntity appliesEntity);

}
