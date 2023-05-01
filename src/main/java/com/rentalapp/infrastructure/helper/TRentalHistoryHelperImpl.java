package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.RentalHistoryModel;
import com.rentalapp.infrastructure.model.TRentalHistoryModel;
import org.springframework.stereotype.Component;

@Component
public class TRentalHistoryHelperImpl implements TRentalHistoryHelper {
    @Override
    public TRentalHistoryModel toTableModel(RentalHistoryModel model) {
        return TRentalHistoryModel.builder()
                .id(model.getId())
                .customerId(model.getCustomerId())
                .bookId(model.getBookId())
                .rentalStartDate(model.getRentalStartDate())
                .scheduledReturnDate(model.getScheduledReturnDate())
                .returnCompletionDate(model.getReturnCompletionDate())
                .build();
    }

    @Override
    public RentalHistoryModel toModel(TRentalHistoryModel model) {
        return RentalHistoryModel.builder()
                .id(model.getId())
                .customerId(model.getCustomerId())
                .bookId(model.getBookId())
                .rentalStartDate(model.getRentalStartDate())
                .scheduledReturnDate(model.getScheduledReturnDate())
                .returnCompletionDate(model.getReturnCompletionDate())
                .build();
    }
}
