package com.rentalapp.domain.service;

import com.rentalapp.domain.info.RentalInfo;

import java.util.List;

public interface RentalService {
    int doRental(RentalInfo info);

    List<String> doReturn(RentalInfo info);
}
