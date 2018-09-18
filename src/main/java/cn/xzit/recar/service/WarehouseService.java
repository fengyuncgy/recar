package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.WarehouseDto;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WarehouseService {

    CePage<WarehouseDto> list (Pageable pageable);



    boolean deleteWarehouse(List<Integer> ids);

    boolean updateWarehouseNum(int id ,int num);

    WarehouseDto findOne(int id);


    boolean updatePrice(WarehouseEntity warehouseEntity);
}
