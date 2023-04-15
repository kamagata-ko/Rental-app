package com.rentalapp.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.rentalapp.application.api.CustomerApi;
import com.rentalapp.application.helper.CustomerHelper;
import com.rentalapp.application.model.CustomerRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.domain.service.CustomerService;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

	private final CustomerService service;

	private final CustomerHelper helper;

	@Override
	public int insertCustomer(CustomerRequest request) {
		return service.insert(helper.toCustomerModel(request));
	}

	@Override
	public CustomerResponse selectOne(String id) {
		CustomerModel result = service.selectOne(Integer.parseInt(id));
		return helper.toCustomerResponse(result);
	}

	@Override
	public List<CustomerResponse> selectAll() {
		List<CustomerResponse> list = new ArrayList<CustomerResponse>();
		List<CustomerModel> result = service.selectAll();
		for (CustomerModel tableModel : result) {
			list.add(helper.toCustomerResponse(tableModel));
		}
		return list;
	}

	@Override
	public int update(int id, CustomerRequest request) {
		request.setId(id);
		CustomerModel model = helper.toCustomerModel(request);
		return service.update(model);
	}

	@Override
	public int deleteOne(int id) {
		return service.deleteOne(id);
	}
}
