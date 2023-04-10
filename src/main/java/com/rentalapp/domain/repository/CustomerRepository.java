package com.rentalapp.domain.repository;

import java.util.List;

import com.rentalapp.model.CustomerModel;

public interface CustomerRepository {

	int insert(CustomerModel model);

	CustomerModel selectOne(int id);

	List<CustomerModel> selectAll();

	int updateByPrimaryKeySelective(CustomerModel model);

	int deleteOne(int id);
}
