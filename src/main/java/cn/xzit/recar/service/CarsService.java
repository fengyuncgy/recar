package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CarsDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.CarsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarsService  {

    boolean addCars(CarsEntity carsEntity);
    boolean updateCars(CarsEntity carsEntity) ;
    boolean deleteCars(List<Integer> ids);


    CePage<CarsDto> list(Pageable pageable);
    List<CarsDto> getOnes(int id);

    CarsDto findOne(int carId);
}
