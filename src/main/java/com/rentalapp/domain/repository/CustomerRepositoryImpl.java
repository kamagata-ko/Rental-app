package com.rentalapp.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rentalapp.mapper.CustomerMapper;
import com.rentalapp.model.CustomerModel;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private CustomerMapper mapper;

	@Override
	public int insertCustomer(CustomerModel model) {
		LocalDateTime ldt = LocalDateTime.now();
		model.setRegisterDate(ldt);
		model.setUpdateDate(ldt);
		return mapper.insertCustomer(model);
	}

	@Override
	public CustomerModel selectOne(String id) {
		return mapper.selectOne(id);
	}

	@Override
	public List<CustomerModel> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKeySelective(CustomerModel model) {
		LocalDateTime ldt = LocalDateTime.now();
		model.setUpdateDate(ldt);
		return mapper.updateByPrimaryKeySelective(model);
	}

}
