package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.PartGroupDto;
import cn.xzit.recar.bean.entity.PartGroupsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartGroupsJpa extends BaseJpa<PartGroupsEntity> {

    @Query("select new cn.xzit.recar.bean.domain.PartGroupDto(p.partGroupid,p.groupName,p2.groupName,p.preid) from PartGroupsEntity p " +
            "left join PartGroupsEntity p2 on p.preid=p2.partGroupid")
    List<PartGroupDto> findAllDto();
    @Query("select new cn.xzit.recar.bean.domain.PartGroupDto(p.partGroupid,p.groupName,p2.groupName,p.preid) from PartGroupsEntity p " +
            "left join PartGroupsEntity p2 on p.preid=p2.partGroupid")
    List<PartGroupDto> findAllDtoPageable(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.PartGroupDto(p.partGroupid,p.groupName,p2.groupName,p.preid) from PartGroupsEntity p " +
            "left join PartGroupsEntity p2 on p.preid=p2.partGroupid " +
            "where p.partGroupid = ?1")
    PartGroupDto findDtoById(int id);
}
