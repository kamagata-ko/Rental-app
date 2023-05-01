package com.rentalapp.application.api;

import com.rentalapp.application.model.RentalRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("rental")
public interface RentalApi {
    @GetMapping("do-rental")
    int doRental(@RequestBody RentalRequest request);
}
