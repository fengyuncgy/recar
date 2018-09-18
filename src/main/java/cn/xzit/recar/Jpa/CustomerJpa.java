package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.CustomerDto;
import cn.xzit.recar.bean.entity.CustomersEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface CustomerJpa extends BaseJpa<CustomersEntity>{


    @Query("select new cn.xzit.recar.bean.domain.CustomerDto(c.customerid,c.name,c.account,c.tel,c.sex,c.age,c.time,c.status) from CustomersEntity c")
    List<CustomerDto> findAllbyQuery(Pageable pageable);

    @Query("select c from CustomersEntity c where c.account=?1")
    CustomersEntity findOneByAccount(String account);


    @Query("select c from CustomersEntity c where c.customerid=?1")
    CustomersEntity findByCustomerid(int id);


    @Query("select new cn.xzit.recar.bean.domain.CustomerDto(c.customerid,c.name,c.account,c.tel,c.sex,c.age,c.time,c.status) " +
            "from CustomersEntity c " +
            "where c.account=?1 and c.password=?2 ")
    CustomerDto login(String account ,String password);



    @Query("update CustomersEntity c  set  c.password = ?2 " +
            "where c.customerid  = ?1 ")
    @Modifying(clearAutomatically = true)
    void updatePassword(int id ,String password);


    @Query("select new cn.xzit.recar.bean.domain.CustomerDto(c.customerid,c.name,c.account,c.tel,c.sex,c.age,c.time,c.status) from CustomersEntity c " +
            "where c.customerid  = ?1 and c.password = ?2 ")
    CustomerDto existsByCustomerid(int id ,String password);
}
