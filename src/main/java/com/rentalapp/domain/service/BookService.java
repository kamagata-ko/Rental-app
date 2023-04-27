package com.rentalapp.domain.service;

import com.rentalapp.domain.model.BookModel;

import java.util.List;

public interface BookService {
    int insert(BookModel model);

    BookModel selectOne(Integer id);

    List<BookModel> select(Integer limit, Integer offset, String sort);

    int count();

    int update(BookModel model);

    int deleteOne(Integer id);
}
