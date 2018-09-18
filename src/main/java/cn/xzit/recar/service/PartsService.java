package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.PartsDto;
import cn.xzit.recar.bean.entity.PartsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartsService {

    boolean addPart(PartsEntity partsEntity);

    boolean updatePart(PartsEntity partsEntity);

    boolean deletePart(List<Integer> ids);

    PartsDto findOne(int id);

    List<PartsDto> findAll();

    CePage<PartsDto> list(Pageable pageable);

    List<PartsDto> findAllByGroupId(int id);
}
