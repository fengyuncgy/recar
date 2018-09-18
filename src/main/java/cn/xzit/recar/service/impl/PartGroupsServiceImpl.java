package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.PartGroupsJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartGroupDto;
import cn.xzit.recar.bean.entity.PartGroupsEntity;
import cn.xzit.recar.service.PartGroupsService;
import cn.xzit.recar.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartGroupsServiceImpl extends CommonService implements PartGroupsService  {

    @Autowired
    private PartGroupsJpa partGroupsJpa ;

    @Override
    public CePage<PartGroupDto> list(Pageable pageable) {
        return page(partGroupsJpa.findAllDtoPageable(pageable),pageable,partGroupsJpa.count());
    }

    @Override
    public List<PartGroupDto> findAll() {
        return partGroupsJpa.findAllDto();
    }

    @Override
    public PartGroupDto findOne(int id) {
        return partGroupsJpa.findDtoById(id);
    }

    @Override
    public boolean updatePartGroups(PartGroupsEntity partGroupsEntity) {
        if(partGroupsEntity==null) return false;
        partGroupsJpa.save(partGroupsEntity);
        return true;
    }

    @Override
    public boolean addPartGroups(PartGroupsEntity partGroupsEntity) {
        if(partGroupsEntity==null) return false;
        partGroupsJpa.save(partGroupsEntity);
        return true;
    }

    @Override
    public boolean deletePartGroups(List<Integer> ids) {
        List<PartGroupsEntity> partGroupsEntities = new ArrayList<>();
        ids.forEach(id->{
            PartGroupsEntity partGroupsEntity = new PartGroupsEntity();
            partGroupsEntity.setPartGroupid(id);
            partGroupsEntities.add(partGroupsEntity);
        });
        partGroupsJpa.deleteAll(partGroupsEntities);
        return true;
    }
}
