package com.rentalapp.application.model;

import java.time.LocalDateTime;

public record BookCreateRequest(
        String bookName,
        String author,
        String publisher,
        LocalDateTime arrivalData) {
}
