package com.rentalapp.application.helper;

import com.rentalapp.application.model.RentalRequest;
import com.rentalapp.application.model.RentalResponse;
import com.rentalapp.application.model.ReturnRequest;
import com.rentalapp.application.model.dto.BookDto;
import com.rentalapp.application.model.dto.RentingBookDto;
import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.model.RentalBooksModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalHelperImpl implements RentalHelper {
    @Override
    public RentalInfo toRentalInfo(RentalRequest request) {
        return RentalInfo.builder()
                .customerId(request.customerId())
                .bookIds(request.bookIds())
                .build();
    }

    @Override
    public RentalInfo toRentalInfo(ReturnRequest request) {
        return RentalInfo.builder()
                .rentalId(request.rentalId())
                .build();
    }

    @Override
    public RentalResponse toResponse(List<RentalBooksModel> rentalBooksModelList) {
        List<RentingBookDto> list = new ArrayList<>();
        rentalBooksModelList.forEach(e -> {
            Integer rentalId = e.getRentalId();
            BookDto bookDto = BookDto.builder()
                    .id(e.getBookModel().getId())
                    .bookName(e.getBookModel().getBookName())
                    .author(e.getBookModel().getAuthor())
                    .publisher(e.getBookModel().getPublisher())
                    .status(e.getRentalId().byteValue())
                    .arrivalData(e.getBookModel().getArrivalData())
                    .registerDate(e.getBookModel().getRegisterDate())
                    .updateDate(e.getBookModel().getUpdateDate())
                    .deleteFlg(e.getRentalId().byteValue())
                    .build();
            RentingBookDto res = RentingBookDto.builder()
                    .rentalId(rentalId)
                    .bookDto(bookDto)
                    .build();
            list.add(res);
        });
        return RentalResponse.builder()
                .rentingBookDtoList(list)
                .build();
    }

}
