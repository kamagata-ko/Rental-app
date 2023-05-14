package com.rentalapp.application.controller;

import com.rentalapp.application.api.RentalApi;
import com.rentalapp.application.helper.RentalHelper;
import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.ReturnRequest;
import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {
    private final RentalService service;
    private final RentalHelper helper;

    @Override
    public int doRental(RentalRequest request) {
        RentalInfo rentalInfo = helper.toRentalInfo(request);
        return service.doRental(rentalInfo);
    }

    @Override
    public List<String> doReturn(ReturnRequest request) {
        RentalInfo rentalInfo = helper.toRentalInfo(request);
        return service.doReturn(rentalInfo);
    }
}
