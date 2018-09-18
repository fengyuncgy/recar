package cn.xzit.recar.Jpa;

import cn.xzit.recar.Jpa.common.BaseJpa;
import cn.xzit.recar.bean.domain.SalaryDto;
import cn.xzit.recar.bean.entity.SalaryEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaryJpa extends BaseJpa<SalaryEntity> {




    @Query("select new cn.xzit.recar.bean.domain.SalaryDto(s.employeeid,e.name,s.baseSalary,s.addSalary,s.finishCount,s.monthCount,s.hours,s.addProportion) from SalaryEntity s " +
            "left join s.employeesByEmployeeid e  ")
    List<SalaryDto> findSalaryDto();



    @Query("select new cn.xzit.recar.bean.domain.SalaryDto(s.employeeid,e.name,s.baseSalary,s.addSalary,s.finishCount,s.monthCount,s.hours,s.addProportion) from SalaryEntity s " +
            "left join s.employeesByEmployeeid e " +
            "where s.employeeid=?1 ")
    SalaryDto findByEmployeeid(int employeeid);
}
