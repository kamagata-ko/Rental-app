package com.rentalapp.domain.service;

import java.util.List;

import com.rentalapp.model.CustomerModel;

public interface CustomerService {

	int insert(CustomerModel model);

	CustomerModel selectOne(int id);

	List<CustomerModel> selectAll();

	int update(CustomerModel model);

	int deleteOne(int id);
}
