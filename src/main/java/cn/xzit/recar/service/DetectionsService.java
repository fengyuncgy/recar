package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.DetectionsDto;
import cn.xzit.recar.bean.entity.DetectionsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetectionsService {

    CePage<DetectionsDto> list (Pageable pageable);

    boolean addDetection(DetectionsEntity detectionsEntity);

    boolean  updateStatus(int status,int id);

    boolean deleteDetection(List<Integer> ids);

    List<DetectionsDto> findAll();
    List<DetectionsDto> findByEmployeeid(int id);
    List<DetectionsDto> findByCarid(List<Integer> id);

    DetectionsDto findOne(int id);

    boolean updateStatus(DetectionsEntity detectionsEntity);
    boolean updateDetection(DetectionsEntity detectionsEntity);
}
