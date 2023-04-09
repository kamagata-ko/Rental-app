package com.rentalapp.domain.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentalapp.infrastructure.helper.TCustomerModelHelper;
import com.rentalapp.infrastructure.mapper.CustomerMapper;
import com.rentalapp.infrastructure.model.TCustomerModel;
import com.rentalapp.model.CustomerModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

	private final CustomerMapper mapper;

	private final TCustomerModelHelper helper;

	@Override
	public int insert(CustomerModel model) {
		LocalDateTime ldt = LocalDateTime.now();
		model.setRegisterDate(ldt);
		model.setUpdateDate(ldt);
		return mapper.insert(helper.toTableModel(model));
	}

	@Override
	public CustomerModel selectOne(int id) {
		TCustomerModel result = mapper.selectOne(id);
		return helper.toModel(result);
	}

	@Override
	public List<CustomerModel> selectAll() {
		// 結果格納用のリストを作成。
		List<CustomerModel> list = new ArrayList<CustomerModel>();
		List<TCustomerModel> result = mapper.selectAll();
		for (TCustomerModel tableModel : result) {
			list.add(helper.toModel(tableModel));
		}
		return list;
	}

	@Override
	public int updateByPrimaryKeySelective(CustomerModel model) {
		LocalDateTime ldt = LocalDateTime.now();
		model.setUpdateDate(ldt);
		return mapper.updateByPrimaryKeySelective(helper.toTableModel(model));
	}

	@Override
	public int deleteOne(int id) {
		return mapper.deleteOne(id);
	}

}
