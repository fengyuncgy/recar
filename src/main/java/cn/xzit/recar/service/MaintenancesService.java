package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancesDto;
import cn.xzit.recar.bean.entity.MaintenancesEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaintenancesService {


    boolean addMaintenance(MaintenancesEntity maintenancesEntity);

    boolean updateEmployeeid(MaintenancesEntity maintenancesEntity);

    boolean updateStatus(MaintenancesEntity maintenancesEntity);

    boolean updateMaintenance(MaintenancesEntity maintenancesEntity);

    boolean deleteMaintenance(List<Integer> ids);

    MaintenancesDto findOne(int id);

    boolean findOne(int carId, int orderid);

    List<MaintenancesDto> findByCarId(List<Integer> carId);

    CePage<MaintenancesDto> list(Pageable pageable);

    List<MaintenancesDto> findAll();

    List<MaintenancesDto> findByEmployeeId(int id);

    List<MaintenancesDto> findDtoByCustomerId(int id);

}
