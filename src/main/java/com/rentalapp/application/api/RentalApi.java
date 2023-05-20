package com.rentalapp.application.api;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.RentalResponse;
import com.rentalapp.application.model.ReturnRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("rentals")
public interface RentalApi {
    @PostMapping
    int doRental(@RequestBody RentalRequest request);

    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void doReturn(@RequestBody ReturnRequest request);

    @GetMapping(value = "{customerId}")
    RentalResponse fetchRentals(@PathVariable("customerId") Integer customerId);
}
