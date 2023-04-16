package com.rentalapp.application.helper;

import org.springframework.stereotype.Component;

import com.rentalapp.application.model.CustomerRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.model.CustomerModel;

/**
 * 顧客APIヘルパー実装クラス.
 */
@Component
public class CustomerHelperImpl implements CustomerHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerModel toCustomerModel(CustomerRequest req) {
		CustomerModel model = new CustomerModel();
		model.setId(req.getId());
		model.setPassword(req.getPassword());
		model.setName(req.getName());
		model.setSex(req.getSex());
		model.setBirthday(req.getBirthday());
		model.setRegisterDate(req.getRegisterDate());
		model.setUpdateDate(req.getUpdateDate());
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerResponse toCustomerResponse(CustomerModel model) {
		CustomerResponse res = new CustomerResponse();
		res.setId(model.getId());
		res.setPassword(model.getPassword());
		res.setName(model.getName());
		res.setSex(model.getSex());
		res.setBirthday(model.getBirthday());
		res.setRegisterDate(model.getRegisterDate());
		res.setUpdateDate(model.getUpdateDate());
		return res;
	}

}
