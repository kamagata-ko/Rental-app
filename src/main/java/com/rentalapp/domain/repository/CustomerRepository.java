package com.rentalapp.domain.repository;

import com.rentalapp.model.CustomerModel;

import java.util.List;

public interface CustomerRepository {

    int insert(CustomerModel model);

    CustomerModel selectOne(String id);

    List<CustomerModel> selectAll();

    int updateByPrimaryKeySelective(CustomerModel model);
}
