package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.BookModel;
import com.rentalapp.infrastructure.model.TBookModel;

public interface TBookModelHelper {
    TBookModel toTableModel(BookModel model);

    BookModel toModel(TBookModel model);
}
