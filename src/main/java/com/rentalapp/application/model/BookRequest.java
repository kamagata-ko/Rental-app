package com.rentalapp.application.model;

import java.time.LocalDateTime;


public record BookRequest(
        String book_name,
        String author,
        String publisher,
        int status,
        LocalDateTime arrival_data,
        LocalDateTime update_date,
        int delete_flg) {
}
