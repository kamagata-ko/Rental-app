package com.rentalapp.application.helper;

import com.rentalapp.application.model.BookCreateRequest;
import com.rentalapp.application.model.BookResponse;
import com.rentalapp.application.model.BookUpdateRequest;
import com.rentalapp.domain.model.BookModel;

public interface BookHelper {
    BookModel toModel(BookCreateRequest req);

    BookModel toModel(BookUpdateRequest req, Integer id);

    BookResponse toResponse(BookModel model);
}
