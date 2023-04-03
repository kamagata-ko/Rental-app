package com.rentalapp.domain.service;

import java.util.List;

import com.rentalapp.model.CustomerModel;

public interface CustomerService {

	public int insert(CustomerModel model);

	public CustomerModel selectOne(String id);

	public List<CustomerModel> selectAll();

	public int update(CustomerModel model);
}
