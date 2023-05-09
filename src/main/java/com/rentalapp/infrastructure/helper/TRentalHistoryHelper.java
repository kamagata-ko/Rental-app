package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.RentalModel;
import com.rentalapp.infrastructure.model.TRentalModel;

public interface TRentalHistoryHelper {
    TRentalModel toTableModel(RentalModel model);

    RentalModel toModel(TRentalModel model);
}
