package com.rentalapp.application.api;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.ReturnRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("rentals")
public interface RentalApi {
    @PostMapping
    int doRental(@RequestBody RentalRequest request);

    @PutMapping
    List<String> doReturn(@RequestBody ReturnRequest request);
}
