package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.WarehouseDto;
import cn.xzit.recar.bean.entity.WarehouseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseJpa extends BaseJpa<WarehouseEntity>{

    @Query("select new cn.xzit.recar.bean.domain.WarehouseDto(w.id,w.partid,w.inPrice,w.ourPrice,w.num,w.erorrMessage,w.place,p.partName,g.groupName) from WarehouseEntity w " +
            "left join w.partsByPartid p " +
            "left join p.partGroupsByPartGroupid g " +
            "where w.id=?1")
    WarehouseDto findOne(int id);

    @Query("select new cn.xzit.recar.bean.domain.WarehouseDto(w.id,w.partid,w.inPrice,w.ourPrice,w.num,w.erorrMessage,w.place,p.partName,g.groupName) from WarehouseEntity w " +
            "left join w.partsByPartid p " +
            "left join p.partGroupsByPartGroupid g ")
    List<WarehouseDto> list(Pageable pageable);

    @Query("update WarehouseEntity w set w.num = w.num+?2 where w.partid=?1 ")
    @Modifying(clearAutomatically = true)
    void updateNum(int partid , int num);
    @Query("delete from WarehouseEntity w where w.partid=?1")
    @Modifying(clearAutomatically = true)
    void deleteByI2d(Integer id);
}
