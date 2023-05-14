package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;

import java.util.List;

public interface RentalRepository {
    int doRental(RentalInfo info);

    List<String> doReturn(RentalInfo info);
}
