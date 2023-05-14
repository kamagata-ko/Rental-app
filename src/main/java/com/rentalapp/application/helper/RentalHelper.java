package com.rentalapp.application.helper;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.ReturnRequest;
import com.rentalapp.domain.info.RentalInfo;

public interface RentalHelper {
    RentalInfo toRentalInfo(RentalRequest request);

    RentalInfo toRentalInfo(ReturnRequest request);
}
