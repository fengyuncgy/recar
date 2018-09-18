package cn.xzit.recar.service;

import cn.xzit.recar.bean.domain.CePage;
import cn.xzit.recar.bean.domain.CustomerDto;
import cn.xzit.recar.bean.model.CustomerModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
     CePage<CustomerDto> findAll(Pageable pageable);

     CustomerDto findOne(int id);

     boolean insertCustomer(CustomerModel customerModel);

     long updateCustomer(CustomerModel customerModel);

     boolean updatePassword(int id,String old ,String newPass);

     boolean deleteCustomer(List<Integer> ids);

     CustomerDto login(String account ,String password);
}
