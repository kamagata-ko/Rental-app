package com.rentalapp.domain.service;

import com.rentalapp.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    int insert(CustomerModel model);

    CustomerModel selectOne(String id);

    List<CustomerModel> selectAll();

    int update(CustomerModel model);
}
