package com.rentalapp.application.helper;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.domain.info.RentalInfo;
import org.springframework.stereotype.Component;

@Component
public class RentalHelperImpl implements RentalHelper {
    @Override
    public RentalInfo toRentalInfo(RentalRequest request) {
        return RentalInfo.builder()
                .customerId(request.customerId())
                .bookId(request.bookIds())
                .build();
    }
}
