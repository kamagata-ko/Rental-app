package com.rentalapp.application.model;

import java.time.LocalDateTime;

public record BookUpdateRequest(
        String bookName,
        String author,
        String publisher,
        int status,
        LocalDateTime arrivalData,
        LocalDateTime updateDate,
        int deleteFlg
) {
}
