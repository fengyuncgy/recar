package cn.xzit.recar.service.impl;

import cn.xzit.recar.Jpa.CustomerJpa;
import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.CustomerDto;
import cn.xzit.recar.bean.entity.CustomersEntity;
import cn.xzit.recar.bean.model.CustomerModel;
import cn.xzit.recar.service.CustomerService;
import cn.xzit.recar.service.common.CommonService;
import cn.xzit.recar.util.MD5Util;
import cn.xzit.recar.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CustomerServiceImpl extends CommonService implements CustomerService {

    @Autowired
    private CustomerJpa customerJpa;
    @Override
    public CePage<CustomerDto> findAll(Pageable pageable) {
        return page(customerJpa.findAllbyQuery(pageable),pageable,customerJpa.count());
    }

    @Override
    public CustomerDto findOne(int id) {
        CustomersEntity customersEntity = customerJpa.findByCustomerid(id);
        if(customersEntity==null) return null;
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerid(customersEntity.getCustomerid());
        customerDto.setAccount(customersEntity.getAccount());
        customerDto.setAge(customersEntity.getAge());
        customerDto.setName(customersEntity.getName());
        customerDto.setSex(customersEntity.getSex());
        customerDto.setTel(customersEntity.getTel());
        return customerDto;
    }

    @Override
    public boolean insertCustomer(CustomerModel customerModel) {

        if(customerJpa.findOneByAccount(customerModel.getAccount())!=null)return false;
        CustomersEntity customersEntity = new CustomersEntity();
        setField(customersEntity,customerModel);
        customersEntity.setStatus(0);
        customerJpa.save(customersEntity);


        return true;
    }

    @Override
    public long updateCustomer(CustomerModel customerModel) {
        CustomersEntity customersEntity = customerJpa.getOne(customerModel.getCustomerid());
        if (customersEntity == null) return 2;

        customersEntity.setName(customerModel.getName());
        customersEntity.setAge(customerModel.getAge());
        customersEntity.setTel(customerModel.getTel());
        customersEntity.setSex(customerModel.getSex());
        customerJpa.save(customersEntity);
        return 0;
    }

    @Override
    @Transactional
    public boolean updatePassword(int id,String old ,String newPass) {
        CustomerDto customerDto = customerJpa.existsByCustomerid(id,MD5Util.string32MD5(old));
        if(customerDto == null) return false;
        customerJpa.updatePassword(id,MD5Util.string32MD5(newPass));
        return true;
    }

    @Override
    @Transactional
    public boolean deleteCustomer(List<Integer> ids) {

        if(ids==null||ids.size()==0) return false;
        List<CustomersEntity> customersEntities = new ArrayList<>();
        for(Integer i :ids){
            if(i==null) return false;
            CustomersEntity customersEntity = new CustomersEntity();
            customersEntity.setCustomerid(i);
            customersEntities.add(customersEntity);
        }
        customerJpa.deleteAll(customersEntities);
        return true;
    }

    @Override
    public CustomerDto login(String account, String password) {
        return customerJpa.login(account,MD5Util.string32MD5(password));
    }


    public void setField( CustomersEntity customersEntity ,CustomerModel customerModel){
        customersEntity.setAccount(customerModel.getAccount());
        customersEntity.setAge(customerModel.getAge());
        customersEntity.setName(customerModel.getName());
        customersEntity.setCustomerid(customerModel.getCustomerid());
        customersEntity.setPassword(MD5Util.string32MD5(customerModel.getPassword()));
        customersEntity.setSex(customerModel.getSex());
        customersEntity.setTel(customerModel.getTel());
        customersEntity.setTime(TimeUtil.nowTime());
    }
}
