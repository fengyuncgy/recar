package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EmployeesDto;
import cn.xzit.recar.bean.domain.SalaryDto;
import cn.xzit.recar.bean.entity.EmployeesEntity;
import cn.xzit.recar.bean.entity.SalaryEntity;
import cn.xzit.recar.bean.model.EmployeesModel;
import org.springframework.data.domain.Pageable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface EmployeesService {

    boolean insertEmployees(EmployeesModel employeesModel);

    EmployeesDto login(String account, String password, int status);

    EmployeesDto findOne(int id);

    boolean deleteEmployees(List<Integer> ids);

    boolean updateEmployees(EmployeesModel employeesModel);

    CePage<EmployeesDto> findAllBySort(Pageable pageable);

    List<EmployeesDto> findAllEmployee();

    boolean updatePassword(int id, String old, String newPass);

    boolean update(EmployeesEntity employeesEntity);

    List<EmployeesDto> findAllByAdmin();

    SalaryDto findSalarDtoByEmployeeid(int employeeid);

    List<SalaryDto> findSalaryDto();

    boolean updateSalary(SalaryEntity salaryEntity);

    CePage<EmployeesDto> findByName(Pageable pageable,String name);
}
