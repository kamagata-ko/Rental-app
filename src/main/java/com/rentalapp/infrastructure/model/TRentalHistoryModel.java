package com.rentalapp.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TRentalHistoryModel {
    private Integer id;
    private Integer customerId;
    private Integer bookId;
    private LocalDateTime rentalStartDate;
    private LocalDateTime scheduledReturnDate;
    private LocalDateTime returnCompletionDate;
}
