package com.rentalapp.domain.repository;

import com.rentalapp.domain.model.BookModel;
import com.rentalapp.infrastructure.helper.TBookModelHelper;
import com.rentalapp.infrastructure.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final BookMapper mapper;
    private final TBookModelHelper helper;

    @Override
    public int insertBook(BookModel model) {
        LocalDateTime now = LocalDateTime.now();
        model.setArrivalData(now);
        model.setRegisterDate(now);
        return mapper.insertBook(helper.toTableModel(model));
    }

    @Override
    public BookModel selectOne(Integer id) {
        return helper.toModel(mapper.selectOne(id));
    }

    @Override
    public List<BookModel> select(Integer limit, Integer offset, String sort) {
        return mapper.select(limit, offset, sort)
                .stream()
                .map(helper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public int updateByPrimaryKeySelective(BookModel model) {
        LocalDateTime now = LocalDateTime.now();
        model.setUpdateDate(now);
        return mapper.updateByPrimaryKeySelective(helper.toTableModel(model));
    }

    @Override
    public int deleteOne(Integer id) {
        return mapper.deleteOne(id);
    }
}
