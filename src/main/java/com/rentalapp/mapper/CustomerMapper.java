package com.rentalapp.mapper;

import com.rentalapp.model.CustomerModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int insert(CustomerModel model);

    CustomerModel selectOne(String id);

    List<CustomerModel> selectAll();

    int updateByPrimaryKeySelective(CustomerModel model);

}
