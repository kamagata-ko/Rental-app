package com.rentalapp.application.model;

import com.rentalapp.application.model.dto.RentingBookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponse {
    List<RentingBookDto> rentingBookDtoList;
}
