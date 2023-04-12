package com.rentalapp.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.rentalapp.application.api.CustomerApi;
import com.rentalapp.domain.service.CustomerService;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

	private final CustomerService service;

	@Override
	public int insertCustomer(CustomerModel model) {
		return service.insert(model);
	}

	@Override
	public CustomerModel selectOne(String id) {
		return service.selectOne(Integer.parseInt(id));
	}

	@Override
	public List<CustomerModel> selectAll() {
		return service.selectAll();
	}

	@Override
	public int update(int id, CustomerModel model) {
		model.setId(id);
		return service.update(model);
	}

	@Override
	public int deleteOne(int id) {
		return service.deleteOne(id);
	}
}
