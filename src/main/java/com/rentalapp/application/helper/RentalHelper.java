package com.rentalapp.application.helper;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.RentalResponse;
import com.rentalapp.application.model.ReturnRequest;
import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.model.RentalBooksModel;

import java.util.List;

public interface RentalHelper {
    RentalInfo toRentalInfo(RentalRequest request);

    RentalInfo toRentalInfo(ReturnRequest request);

    RentalResponse toResponse(List<RentalBooksModel> rentalBooksModelList);
}
