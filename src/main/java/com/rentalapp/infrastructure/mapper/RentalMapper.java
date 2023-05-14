package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TRentalModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RentalMapper {
    int insert(TRentalModel model);

    int doReturn(TRentalModel model);

    TRentalModel select(Integer id);
}
