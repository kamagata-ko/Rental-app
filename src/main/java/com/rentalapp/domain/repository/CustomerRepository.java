package com.rentalapp.domain.repository;

import java.util.List;

import com.rentalapp.model.CustomerModel;

public interface CustomerRepository {

	public int insert(CustomerModel model);

	public CustomerModel selectOne(String id);

	public List<CustomerModel> selectAll();

	public int updateByPrimaryKeySelective(CustomerModel model);
}
