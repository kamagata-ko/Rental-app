package com.rentalapp.application.model;

import java.time.LocalDateTime;

public record BookCreateRequest(
        String book_name,
        String author,
        String publisher,
        LocalDateTime arrival_data) {
}
