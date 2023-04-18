package com.rentalapp.application.helper;

import org.springframework.stereotype.Component;

import com.rentalapp.application.model.CustomerRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.domain.model.CustomerModel;

/**
 * 顧客APIヘルパー実装クラス.
 */
@Component
public class CustomerHelperImpl implements CustomerHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerModel toModel(CustomerRequest req) {
		return CustomerModel.builder()
				.id(req.id())
				.password(req.password())
				.name(req.name())
				.sex(req.sex())
				.birthday(req.birthday())
				.registerDate(req.registerDate())
				.deleteFlg(req.deleteFlg())
				.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerResponse toResponse(CustomerModel model) {
		return CustomerResponse.builder()
				.id(model.getId())
				.password(model.getPassword())
				.name(model.getName())
				.sex(model.getSex())
				.birthday(model.getBirthday())
				.registerDate(model.getRegisterDate())
				.updateDate(model.getUpdateDate())
				.build();
	}

}
