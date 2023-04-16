package com.rentalapp.infrastructure.helper;

import org.springframework.stereotype.Component;

import com.rentalapp.infrastructure.model.TCustomerModel;
import com.rentalapp.model.CustomerModel;

/**
 * 顧客情報ヘルパー実装クラス.
 */
@Component
public class TCustomerModelHelperImpl implements TCustomerModelHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TCustomerModel toTableModel(CustomerModel model) {
		TCustomerModel tableModel = new TCustomerModel();
		tableModel.setId(model.getId());
		tableModel.setPassword(model.getPassword());
		tableModel.setName(model.getName());
		tableModel.setSex(model.getSex());
		tableModel.setBirthday(model.getBirthday());
		tableModel.setRegisterDate(model.getRegisterDate());
		tableModel.setUpdateDate(model.getUpdateDate());
		return tableModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerModel toModel(TCustomerModel tableModel) {
		CustomerModel model = new CustomerModel();
		model.setId(tableModel.getId());
		model.setPassword(tableModel.getPassword());
		model.setName(tableModel.getName());
		model.setSex(tableModel.getSex());
		model.setBirthday(tableModel.getBirthday());
		model.setRegisterDate(tableModel.getRegisterDate());
		model.setUpdateDate(tableModel.getUpdateDate());
		return model;
	}

}
