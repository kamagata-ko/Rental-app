package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.RentalHistoryModel;
import com.rentalapp.infrastructure.model.TRentalHistoryModel;

public interface TRentalHistoryHelper {
    TRentalHistoryModel toTableModel(RentalHistoryModel model);

    RentalHistoryModel toModel(TRentalHistoryModel model);
}
