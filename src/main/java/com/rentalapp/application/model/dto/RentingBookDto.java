package com.rentalapp.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentingBookDto {
    Integer rentalId;
    BookDto bookDto;
}
