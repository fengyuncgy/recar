package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EvaluatesDto;
import cn.xzit.recar.bean.entity.EvaluatesEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EvaluatesService {

    List<EvaluatesDto> findAll();

    CePage<EvaluatesDto> list(Pageable pageable);

    EvaluatesDto findOne(int id);

    boolean addEvaluate(EvaluatesEntity evaluatesEntity);

    boolean updateEvaluate(EvaluatesEntity evaluatesEntity);

    boolean deleteEvaluate(List<Integer> ids);

    List<EvaluatesDto> findByEvaluateid(int id);

    List<EvaluatesDto> findByCarid(List<Integer> id);
}
