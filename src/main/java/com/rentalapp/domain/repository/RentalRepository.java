package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;

public interface RentalRepository {
    int doRental(RentalInfo info);

    void doReturn(RentalInfo info);
}
