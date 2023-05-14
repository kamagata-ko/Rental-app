package com.rentalapp.application.model;

import java.util.List;

public record ReturnRequest(
        List<Integer> rentalId) {
}
