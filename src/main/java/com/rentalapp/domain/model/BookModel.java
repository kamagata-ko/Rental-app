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
    private String book_name;
    private String author;
    private String publisher;
    private int status;
    private LocalDateTime arrival_data;
    private LocalDateTime update_date;
    private int delete_flg;
}
