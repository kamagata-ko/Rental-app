package com.rentalapp.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rentalapp.infrastructure.model.TCustomerModel;

@Mapper
public interface CustomerMapper {

	int insert(TCustomerModel model);

	TCustomerModel selectOne(int id);

	List<TCustomerModel> selectAll();

	int updateByPrimaryKeySelective(TCustomerModel model);

	int deleteOne(int id);

}
