package com.rentalapp.application.controller;

import com.rentalapp.application.api.BookApi;
import com.rentalapp.application.helper.BookHelper;
import com.rentalapp.application.model.BookCreateRequest;
import com.rentalapp.application.model.BookResponse;
import com.rentalapp.application.model.BookUpdateRequest;
import com.rentalapp.application.model.BooksResponse;
import com.rentalapp.domain.model.BookModel;
import com.rentalapp.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController implements BookApi {
    private final BookService service;
    private final BookHelper helper;

    @Override
    public int insertBook(BookCreateRequest request) {
        return service.insert(helper.toModel(request));
    }

    @Override
    public BookResponse selectOne(Integer id) {
        BookModel model = service.selectOne(id);
        return helper.toResponse(model);
    }

    @Override
    public BooksResponse select(Integer limit, Integer offset, String sort) {
        List<BookResponse> list = service.select(limit, offset, sort)
                .stream()
                .map(helper::toResponse)
                .collect(Collectors.toList());
        int count = service.count();
        return BooksResponse.builder()
                .books(list)
                .count(count)
                .build();
    }

    @Override
    public int update(Integer id, BookUpdateRequest req) {
        BookModel model = helper.toModel(req, id);
        return service.update(model);
    }

    @Override
    public int deleteOne(Integer id) {
        return service.deleteOne(id);
    }
}
