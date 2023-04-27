package com.rentalapp.domain.repository;

import com.rentalapp.domain.model.BookModel;

import java.util.List;

public interface BookRepository {
    int insertBook(BookModel model);

    BookModel selectOne(Integer id);

    List<BookModel> select(Integer limit, Integer offset, String sort);

    int count();

    int updateByPrimaryKeySelective(BookModel model);

    int deleteOne(Integer id);
}
