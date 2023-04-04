package com.rentalapp.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentalapp.mapper.CustomerMapper;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

	private final CustomerMapper mapper;

	@Override
	public int insert(CustomerModel model) {
		LocalDateTime ldt = LocalDateTime.now();
		model.setRegisterDate(ldt);
		model.setUpdateDate(ldt);
		return mapper.insert(model);
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

	@Override
	public int deleteOne(String id) {
		return mapper.deleteOne(id);
	}

}
