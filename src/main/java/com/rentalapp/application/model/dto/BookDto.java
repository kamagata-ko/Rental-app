package com.rentalapp.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    int id;
    String bookName;
    String author;
    String publisher;
    int status;
    LocalDateTime arrivalData;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    int deleteFlg;
}
