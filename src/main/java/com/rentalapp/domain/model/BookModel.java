package com.rentalapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    private int id;
    private String bookName;
    private String author;
    private String publisher;
    private int status;
    private LocalDateTime arrivalData;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private int deleteFlg;
}
