package com.rentalapp.domain.repository;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.model.RentalBooksModel;

import java.util.List;

public interface RentalRepository {
    int doRental(RentalInfo info);

    void doReturn(RentalInfo info);

    List<RentalBooksModel> fetchRentingBooks(Integer customerId);
}
