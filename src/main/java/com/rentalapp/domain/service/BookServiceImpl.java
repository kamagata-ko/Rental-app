package com.rentalapp.domain.service;

import com.rentalapp.domain.model.BookModel;
import com.rentalapp.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public int insert(BookModel model) {
        return repository.insertBook(model);
    }

    @Override
    public BookModel selectOne(Integer id) {
        return repository.selectOne(id);
    }

    @Override
    public List<BookModel> select(Integer limit, Integer offset, String sort) {
        return repository.select(limit, offset, sort);
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public int update(BookModel model) {
        return repository.updateByPrimaryKeySelective(model);
    }

    @Override
    public int deleteOne(Integer id) {
        return repository.deleteOne(id);
    }
}
