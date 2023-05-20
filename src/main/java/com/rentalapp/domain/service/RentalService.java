package com.rentalapp.domain.service;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.model.RentalBooksModel;

import java.util.List;

public interface RentalService {
    int doRental(RentalInfo info);

    void doReturn(RentalInfo info);

    List<RentalBooksModel> fetchRentingBooks(Integer customerId);
}
