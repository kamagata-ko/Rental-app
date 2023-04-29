package com.rentalapp.application.helper;

import com.rentalapp.application.model.BookCreateRequest;
import com.rentalapp.application.model.BookResponse;
import com.rentalapp.application.model.BookUpdateRequest;
import com.rentalapp.domain.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookHelperImpl implements BookHelper {
    @Override
    public BookModel toModel(BookCreateRequest req) {
        return BookModel.builder()
                .bookName(req.bookName())
                .author(req.author())
                .publisher(req.publisher())
                .build();
    }

    @Override
    public BookModel toModel(BookUpdateRequest req, Integer id) {
        return BookModel.builder()
                .bookName(req.bookName())
                .author(req.author())
                .publisher(req.publisher())
                .status(req.status())
                .arrivalData(req.arrivalData())
                .updateDate(req.updateDate())
                .deleteFlg(req.deleteFlg())
                .build();
    }

    @Override
    public BookResponse toResponse(BookModel model) {
        return BookResponse.builder()
                .id(model.getId())
                .bookName(model.getBookName())
                .author(model.getAuthor())
                .publisher(model.getPublisher())
                .status(model.getStatus())
                .arrivalData(model.getArrivalData())
                .updateDate(model.getUpdateDate())
                .deleteFlg(model.getDeleteFlg())
                .build();
    }
}
