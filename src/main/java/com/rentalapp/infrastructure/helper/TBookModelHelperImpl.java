package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.BookModel;
import com.rentalapp.infrastructure.model.TBookModel;
import org.springframework.stereotype.Component;

@Component
public class TBookModelHelperImpl implements TBookModelHelper {
    @Override
    public TBookModel toTableModel(BookModel model) {
        return TBookModel.builder()
                .id(model.getId())
                .bookName(model.getBookName())
                .author(model.getAuthor())
                .publisher(model.getPublisher())
                .status(model.getStatus())
                .arrivalData(model.getArrivalData())
                .registerDate(model.getRegisterDate())
                .deleteFlg(model.getDeleteFlg())
                .build();
    }

    @Override
    public BookModel toModel(TBookModel model) {
        return BookModel.builder()
                .id(model.getId())
                .bookName(model.getBookName())
                .author(model.getAuthor())
                .publisher(model.getPublisher())
                .status(model.getStatus())
                .arrivalData(model.getArrivalData())
                .registerDate(model.getRegisterDate())
                .updateDate(model.getUpdateDate())
                .deleteFlg(model.getDeleteFlg())
                .build();
    }
}
