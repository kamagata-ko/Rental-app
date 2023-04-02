package com.rentalapp.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalapp.domain.repository.CustomerRepository;
import com.rentalapp.model.CustomerModel;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public int insertCustomer(CustomerModel model) {
		return repository.insertCustomer(model);
	}

	@Override
	public CustomerModel selectOne(String id) {
		return repository.selectOne(id);
	}

	@Override
	public List<CustomerModel> selectAll() {
		return repository.selectAll();
	}

	@Override
	public int update(CustomerModel model) {
		return repository.updateByPrimaryKeySelective(model);
	}

}
