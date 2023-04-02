package com.rentalapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rentalapp.model.CustomerModel;

@Mapper
public interface CustomerMapper {

	public int insertCustomer(CustomerModel model);

	public CustomerModel selectOne(String id);

	public List<CustomerModel> selectAll();

	public int updateserective(CustomerModel model);

}
