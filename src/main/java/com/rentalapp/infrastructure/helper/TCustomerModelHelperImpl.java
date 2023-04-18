package com.rentalapp.infrastructure.helper;

import org.springframework.stereotype.Component;

import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.infrastructure.model.TCustomerModel;

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
		return TCustomerModel.builder()
				.id(model.getId())
				.password(model.getPassword())
				.name(model.getName())
				.sex(model.getSex())
				.birthday(model.getBirthday())
				.registerDate(model.getRegisterDate())
				.updateDate(model.getUpdateDate())
				.deleteFlg(model.getDeleteFlg())
				.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerModel toModel(TCustomerModel tableModel) {
		return CustomerModel.builder()
				.id(tableModel.getId())
				.password(tableModel.getPassword())
				.name(tableModel.getName())
				.sex(tableModel.getSex())
				.birthday(tableModel.getBirthday())
				.registerDate(tableModel.getRegisterDate())
				.updateDate(tableModel.getUpdateDate())
				.deleteFlg(tableModel.getDeleteFlg())
				.build();
	}

}
