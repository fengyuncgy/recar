package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.AppliesDto;
import cn.xzit.recar.bean.entity.AppliesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppliesJpa extends BaseJpa<AppliesEntity> {


    @Query("update AppliesEntity a set a.applyStatus=?2 where a.applyid=?1")
    @Modifying(clearAutomatically = true)
    void updateStatus(int applyid,int status);

    @Query("select new cn.xzit.recar.bean.domain.AppliesDto(a.applyid,a.applyName,a.applyTime,a.applyPrice,a.applyStatus,a.maintainTime," +
            "c.carid,c.brand,cu.customerid,cu.name) from AppliesEntity a " +
            "left join a.carsByCarid c " +
            "left join c.customersByCustomerid cu")
    List<AppliesDto> findAllBySort(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.AppliesDto(a.applyid,a.applyName,a.applyTime,a.applyPrice,a.applyStatus,a.maintainTime," +
            "c.carid,c.brand,cu.customerid,cu.name) from AppliesEntity a " +
            "left join a.carsByCarid c " +
            "left join c.customersByCustomerid cu " +
            "where cu.customerid = ?1 ")
    List<AppliesDto> findOnes(int id );


    @Query("select count(a) from AppliesEntity a " +
            "where a.applyid = ?1 ")
    int countByApplyid(int id );

    @Query("select new cn.xzit.recar.bean.domain.AppliesDto(a.applyid,a.applyName,a.applyTime,a.applyPrice,a.applyStatus,a.maintainTime," +
            "c.carid,c.brand,cu.customerid,cu.name) from AppliesEntity a " +
            "left join a.carsByCarid c " +
            "left join c.customersByCustomerid cu " +
            "where a.applyid=?1 ")
    AppliesDto findOne(int id);



}
