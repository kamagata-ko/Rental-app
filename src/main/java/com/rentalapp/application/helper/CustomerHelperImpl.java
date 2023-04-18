package com.rentalapp.application.helper;

import org.springframework.stereotype.Component;

import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
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
	public CustomerModel toModel(CustomerCreateRequest req) {
		return CustomerModel.builder()
				.password(req.password())
				.name(req.name())
				.sex(req.sex())
				.birthday(req.birthday())
				.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerModel toModel(CustomerUpdateRequest req, int id) {
		return CustomerModel.builder()
				.id(id)
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
