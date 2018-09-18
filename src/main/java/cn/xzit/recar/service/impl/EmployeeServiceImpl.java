package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.EmployeesJpa;
import cn.xzit.recar.Jpa.SalaryJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.EmployeesDto;
import cn.xzit.recar.bean.domain.SalaryDto;
import cn.xzit.recar.bean.entity.EmployeesEntity;
import cn.xzit.recar.bean.entity.SalaryEntity;
import cn.xzit.recar.bean.model.EmployeesModel;
import cn.xzit.recar.constant.RecarConstant;
import cn.xzit.recar.service.EmployeesService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl extends CommonService implements EmployeesService {

    @Autowired
    private EmployeesJpa employeesJpa;


    @Autowired
    private SalaryJpa salaryJpa;

    @Override
    @Transactional
    public boolean insertEmployees(EmployeesModel employeesModel) {
        if(employeesJpa.findOneByAccount(employeesModel.getAccount())!=null){
            return false;
        }
         Integer integer = employeesJpa.maxId();
        integer=integer==null?1:++integer;
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setEmployeeid(integer);
        employeesEntity.setAccount(employeesModel.getAccount());
        employeesEntity.setBirth(employeesModel.getBirth());
        employeesEntity.setName(employeesModel.getName());
        employeesEntity.setSex(employeesModel.getSex());
        employeesEntity.setTel(employeesModel.getTel());
        employeesEntity.setPassword(MD5Util.string32MD5(employeesModel.getPassword()));
        employeesEntity.setType(employeesModel.getType());
        employeesEntity.setAddress(employeesModel.getAddress());
        employeesEntity.setStatus(0);
       if(employeesModel.getType()==1){
           SalaryEntity s= new SalaryEntity();
           s.setEmployeeid(integer);
           s.setAddProportion(0D);
           s.setAddSalary(0d);
           s.setFinishCount(0D);
           s.setMonthCount(0D);
           s.setBaseSalary(0D);
           s.setHours(0D);
           employeesEntity.setSalaryByEmployeeid(s);
       }
        employeesJpa.save(employeesEntity);

        return true;
    }

    @Override
    public EmployeesDto login(String account, String password,int status) {

        EmployeesDto employeesDto = employeesJpa.findByAccountAndPassword(account, MD5Util.string32MD5(password),status);
       return employeesDto;
    }

    @Override
    public EmployeesDto findOne(int id) {
        return employeesJpa.findOne(id);
    }

    @Override
    @Transactional
    public boolean deleteEmployees(List<Integer> ids) {
       List<EmployeesEntity> list = new ArrayList<>();
        if(ids==null||ids.size()==0)
            return false;
        for(Integer i :ids){
            if(i == null) return false;
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setEmployeeid(i);
            list.add(employeesEntity);
        }
        employeesJpa.deleteAll(list);
        return true;
    }

    @Transactional
    @Override
    public boolean updateEmployees(EmployeesModel employeesModel) {

        if (employeesModel==null){
            return false;
        }
        EmployeesEntity employeesEntity = employeesJpa.getOne(employeesModel.getEmployeeid());
        if(employeesEntity==null) return false;
        employeesEntity.setBirth(employeesModel.getBirth());
        employeesEntity.setName(employeesModel.getName());
        employeesEntity.setSex(employeesModel.getSex());
        employeesEntity.setTel(employeesModel.getTel());
        employeesEntity.setAddress(employeesModel.getAddress());
        employeesEntity.setType(employeesModel.getType());
        employeesJpa.save(employeesEntity);

        return true;
    }


    @Override
    public CePage<EmployeesDto> findAllBySort(Pageable pageable) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RecarConstant.date);
        List<EmployeesDto> dtos = employeesJpa.findAllBySort(pageable);
        return page(dtos,pageable,employeesJpa.count());
    }

    @Override
    public List<EmployeesDto> findAllEmployee() {
        return employeesJpa.findAllEmployee();
    }

    @Override
    @Transactional
    public boolean updatePassword(int id, String old, String newPass) {
        EmployeesDto employeesDto = employeesJpa.existsByEmployeeid(id,MD5Util.string32MD5(old));
        if(employeesDto == null) return false;
        employeesJpa.updatePassword(id,MD5Util.string32MD5(newPass));
        return true;
    }

    @Override
    public boolean update(EmployeesEntity employeesEntity) {
        EmployeesEntity  one= employeesJpa.getOne(employeesEntity.getEmployeeid());
        one.setName(employeesEntity.getName());
        one.setAccount(employeesEntity.getAccount());
        one.setSex(employeesEntity.getSex());
        one.setBirth(employeesEntity.getBirth());
        one.setAddress(employeesEntity.getAddress());
        one.setTel(employeesEntity.getTel());
        one.setType(employeesEntity.getType());
        employeesJpa.save(one);
        return true;

    }

    @Override
    public List<EmployeesDto> findAllByAdmin() {
        return employeesJpa.findAllByAdmin();
    }

    @Override
    public SalaryDto findSalarDtoByEmployeeid(int employeeid) {
        return salaryJpa.findByEmployeeid(employeeid);
    }

    @Override
    public List<SalaryDto> findSalaryDto() {
        return salaryJpa.findSalaryDto();
    }

    @Override
    public boolean updateSalary(SalaryEntity salaryEntity) {

        SalaryEntity one =salaryJpa.getOne(salaryEntity.getEmployeeid());
        one.setBaseSalary(salaryEntity.getBaseSalary());
        one.setAddProportion(salaryEntity.getAddProportion());
        one.setHours(salaryEntity.getHours());
        salaryJpa.save(one);
        return true;
    }

    @Override
    public CePage<EmployeesDto> findByName(Pageable pageable,String name) {
        return page(employeesJpa.findByName(pageable,likeAllPer(name)),pageable,employeesJpa.countByName(likeAllPer(name)));
    }


}
