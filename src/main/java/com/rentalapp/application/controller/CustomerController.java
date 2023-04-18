package com.rentalapp.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.rentalapp.application.api.CustomerApi;
import com.rentalapp.application.helper.CustomerHelper;
import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.domain.service.CustomerService;

import lombok.RequiredArgsConstructor;

/**
 * 顧客APIコントローラー.
 */
@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

	/* 顧客サービス */
	private final CustomerService service;

	/* 顧客ヘルパー */
	private final CustomerHelper helper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int insertCustomer(CustomerCreateRequest request) {
		return service.insert(helper.toModel(request));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerResponse selectOne(String id) {
		CustomerModel result = service.selectOne(Integer.parseInt(id));
		return helper.toResponse(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CustomerResponse> selectAll() {
		List<CustomerResponse> list = new ArrayList<CustomerResponse>();
		List<CustomerModel> result = service.selectAll();
		for (CustomerModel tableModel : result) {
			list.add(helper.toResponse(tableModel));
		}
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int update(int id, CustomerUpdateRequest request) {
		CustomerModel model = helper.toModel(request, id);
		return service.update(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteOne(int id) {
		return service.deleteOne(id);
	}
}
