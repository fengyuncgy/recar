package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EmployeesDto;
import cn.xzit.recar.bean.entity.EmployeesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesJpa extends BaseJpa<EmployeesEntity> {
    @Override
    <S extends EmployeesEntity> S save(S s);
    @Query("select e from EmployeesEntity e where e.account=?1 ")
    EmployeesEntity findOneByAccount(String account);
    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where e.account=?1 and e.password=?2 and e.type=?3 and e.status=0")
    EmployeesDto findByAccountAndPassword(String account,String password,int status);
    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e")
    List<EmployeesDto> findAllBySort(Pageable pageable);

    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where  e.employeeid=?1 ")
    EmployeesDto findOne(int id);


    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where  e.employeeid=?1 and e.password=?2 ")
    EmployeesDto existsByEmployeeid(int id, String password);

    @Query("update EmployeesEntity e  set  e.password = ?2 " +
            "where e.employeeid  = ?1 ")
    @Modifying(clearAutomatically = true)
    void updatePassword(int id, String password);
    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where e.type=1")
    List<EmployeesDto> findAllEmployee();
    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where e.type=0")
    List<EmployeesDto> findAllByAdmin();


    @Query("select max (e.employeeid) from EmployeesEntity e")
    Integer maxId();

    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where e.name like ?1")
    List<EmployeesDto> findByName(String s);
    @Query("select new cn.xzit.recar.bean.domain.EmployeesDto(e.employeeid,e.name,e.account,e.sex,e.birth,e.address,e.tel,e.type,e.status) from EmployeesEntity e " +
            "where e.name like ?1")
    List<EmployeesDto> findByName(Pageable pageable, String s);
    @Query("select count(e.employeeid) from EmployeesEntity e " +
            "where e.name like ?1")
    int countByName(String name);
}
