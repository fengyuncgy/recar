package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartGroupDto;
import cn.xzit.recar.bean.entity.PartGroupsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartGroupsService {
    CePage<PartGroupDto> list(Pageable pageable);

    List<PartGroupDto> findAll();


    PartGroupDto findOne(int id);

    boolean updatePartGroups(PartGroupsEntity partGroupsEntity);

    boolean addPartGroups(PartGroupsEntity partGroupsEntity);

    boolean deletePartGroups(List<Integer> ids);


}
