package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.MaintenancePartDto;
import cn.xzit.recar.bean.entity.MaintenancePartEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaintenancePartService {
    CePage<MaintenancePartDto> list(Pageable pageable);

    List<MaintenancePartDto> findByMaintenanceid(int id);

    boolean save (MaintenancePartEntity maintenancePartEntity);
    boolean update (MaintenancePartEntity maintenancePartEntity);

    boolean delete(List<Integer> ids);
}
