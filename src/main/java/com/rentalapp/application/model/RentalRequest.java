package com.rentalapp.application.model;

import java.util.List;

public record RentalRequest(
        Integer customerId,
        List<Integer> bookIds) {

}
