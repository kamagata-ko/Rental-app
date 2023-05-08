package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.RentalModel;
import com.rentalapp.infrastructure.model.TRentalModel;
import org.springframework.stereotype.Component;

@Component
public class TRentalHistoryHelperImpl implements TRentalHistoryHelper {
    @Override
    public TRentalModel toTableModel(RentalModel model) {
        return TRentalModel.builder()
                .id(model.getId())
                .customerId(model.getCustomerId())
                .bookId(model.getBookId())
                .rentalStartDate(model.getRentalStartDate())
                .scheduledReturnDate(model.getScheduledReturnDate())
                .returnCompletionDate(model.getReturnCompletionDate())
                .build();
    }

    @Override
    public RentalModel toModel(TRentalModel model) {
        return RentalModel.builder()
                .id(model.getId())
                .customerId(model.getCustomerId())
                .bookId(model.getBookId())
                .rentalStartDate(model.getRentalStartDate())
                .scheduledReturnDate(model.getScheduledReturnDate())
                .returnCompletionDate(model.getReturnCompletionDate())
                .build();
    }
}
