package com.rentalapp.domain.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalInfo {
    private Integer customerId;
    private List<Integer> bookIds;
}
