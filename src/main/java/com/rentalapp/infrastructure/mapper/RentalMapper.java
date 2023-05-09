package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TRentalModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RentalMapper {
    int insert(TRentalModel model);
}
