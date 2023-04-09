package com.rentalapp.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rentalapp.infrastructure.model.TCustomerModel;

@Mapper
public interface CustomerMapper {

	public int insert(TCustomerModel model);

	public TCustomerModel selectOne(int id);

	public List<TCustomerModel> selectAll();

	public int updateByPrimaryKeySelective(TCustomerModel model);

	public int deleteOne(int id);

}
