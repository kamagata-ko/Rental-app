package com.rentalapp.domain.service;

import com.rentalapp.domain.info.RentalInfo;

public interface RentalService {
    int doRental(RentalInfo info);

    void doReturn(RentalInfo info);
}
