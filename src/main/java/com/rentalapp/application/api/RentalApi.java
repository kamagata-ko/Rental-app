package com.rentalapp.application.api;

import com.rentalapp.application.model.RentalRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("rentals")
public interface RentalApi {
    @PostMapping
    int doRental(@RequestBody RentalRequest request);
}
