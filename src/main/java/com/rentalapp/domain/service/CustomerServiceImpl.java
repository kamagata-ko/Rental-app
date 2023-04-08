package com.rentalapp.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalapp.domain.repository.CustomerRepository;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;

	@Override
	public int insert(CustomerModel model) {
		return repository.insert(model);
	}

	@Override
	public CustomerModel selectOne(int id) {
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

	@Override
	public int deleteOne(int id) {
		return repository.deleteOne(id);
	}
}
