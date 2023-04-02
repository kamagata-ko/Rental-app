package com.rentalapp.domain.service;

import java.util.List;

import com.rentalapp.model.CustomerModel;

public interface CustomerService {

	public int insertCustomer(CustomerModel model);

	public CustomerModel selectOne(String id);

	public List<CustomerModel> selectAll();

}
