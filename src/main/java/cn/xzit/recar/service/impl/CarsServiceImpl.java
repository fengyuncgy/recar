package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.CarsJpa;
import cn.xzit.recar.bean.domain.CarsDto;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.entity.CarsEntity;
import cn.xzit.recar.service.CarsService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class CarsServiceImpl extends CommonService implements CarsService {

    @Autowired
    private CarsJpa carsJpa ;

    @Override
    public boolean addCars(CarsEntity carsEntity) {
        carsJpa.save(carsEntity);
        return true;
    }

    @Override
    public boolean updateCars(CarsEntity carsEntity) {
        if(carsEntity.getCarid()<=0)
            return false;
        carsJpa.save(carsEntity);
        return true;
    }

    @Override
    public boolean deleteCars(List<Integer> ids) {
        List<CarsEntity> carsEntities = new ArrayList<>();
        for (Integer id:ids){
            if(id==null)continue;
            CarsEntity  carsEntity = new CarsEntity();
            carsEntity.setCarid(id);
            carsEntities.add(carsEntity);
        }
        carsJpa.deleteAll(carsEntities);
        return true;
    }

    @Override
    public CePage<CarsDto> list(Pageable pageable) {

        List<CarsDto> allSort = carsJpa.findAllSort(pageable);
        this.setTime(allSort);
        return page(allSort,pageable,carsJpa.count());
    }

    @Override
    public List<CarsDto> getOnes(int id)
    {

        List<CarsDto> ones = carsJpa.findOnes(id);
        this.setTime(ones);
        return ones;
    }

    @Override
    public CarsDto findOne(int carId) {
        CarsDto dtoById = carsJpa.findDtoById(carId);
        setTime(dtoById);
        return dtoById;
    }


    public void setTime( List<CarsDto> all){
        all.forEach(carsDto -> {
            carsDto.setBuyTimeStr(TimeUtil.date(carsDto.getBuyTime().getTime()));
        });
    }

    public void setTime( CarsDto carsDto){
            carsDto.setBuyTimeStr(TimeUtil.date(carsDto.getBuyTime().getTime()));
    }
}
