package com.rentalapp.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String bookName;
    private String author;
    private String publisher;
    private int status;
    private LocalDateTime arrivalData;
    private LocalDateTime updateDate;
    private int deleteFlg;
}
