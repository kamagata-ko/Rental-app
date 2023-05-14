package com.rentalapp.application.helper;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.ReturnRequest;
import com.rentalapp.domain.info.RentalInfo;
import org.springframework.stereotype.Component;

@Component
public class RentalHelperImpl implements RentalHelper {
    @Override
    public RentalInfo toRentalInfo(RentalRequest request) {
        return RentalInfo.builder()
                .customerId(request.customerId())
                .bookIds(request.bookIds())
                .build();
    }

    @Override
    public RentalInfo toRentalInfo(ReturnRequest request) {
        return RentalInfo.builder()
                .rentalId(request.rentalId())
                .build();
    }

}
