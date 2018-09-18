package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.EvaluatesDto;
import cn.xzit.recar.bean.entity.EvaluatesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluatesJpa extends BaseJpa<EvaluatesEntity> {


    @Query("select new cn.xzit.recar.bean.domain.EvaluatesDto(e.evaluateid,o.name,e.server,e.maintenance,e.value,e.status" +
            ",e.employeeid,em.name) from EvaluatesEntity  e " +
            "left join e.employeesByEmployeeid em " +
            "left join e.ordersByEvaluateid o ")
    List<EvaluatesDto> findAllDto(Pageable pageable);
    @Query("select new cn.xzit.recar.bean.domain.EvaluatesDto(e.evaluateid,o.name,e.server,e.maintenance,e.value,e.status" +
            ",e.employeeid,em.name) from EvaluatesEntity  e " +
            "left join e.employeesByEmployeeid em " +
            "left join e.ordersByEvaluateid o ")
    List<EvaluatesDto> findAllDto();
    @Query("select new cn.xzit.recar.bean.domain.EvaluatesDto(e.evaluateid,o.name,e.server,e.maintenance,e.value,e.status" +
            ",e.employeeid,em.name) from EvaluatesEntity  e " +
            "left join e.employeesByEmployeeid em " +
            "left join e.ordersByEvaluateid o " +
            "where  e.evaluateid=?1 ")
    EvaluatesDto findOne(int id);


    @Query("select new cn.xzit.recar.bean.domain.EvaluatesDto(e.evaluateid,o.name,e.server,e.maintenance,e.value,e.status" +
            ",e.employeeid,em.name) from EvaluatesEntity  e " +
            "left join e.employeesByEmployeeid em " +
            "left join e.ordersByEvaluateid o " +
            "where  e.employeeid=?1 ")
    List<EvaluatesDto> findByEvaluateid(int id);



    @Query("select new cn.xzit.recar.bean.domain.EvaluatesDto(e.evaluateid,o.name,e.server,e.maintenance,e.value,e.status" +
            ",e.employeeid,em.name) from EvaluatesEntity  e " +
            "left join e.employeesByEmployeeid em " +
            "left join e.ordersByEvaluateid o " +
            "where  o.carid in ?1 ")
    List<EvaluatesDto> findByCarid(List<Integer> id);
    @Query("select e from EvaluatesEntity e " +
            "where e.evaluateid = ?1 ")
    EvaluatesEntity find(int evaluateid);
}
