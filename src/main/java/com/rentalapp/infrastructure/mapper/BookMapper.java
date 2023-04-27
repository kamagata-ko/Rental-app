package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TBookModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    int insertBook(TBookModel model);

    TBookModel selectOne(int id);

    List<TBookModel> select(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort);

    int count();

    int updateByPrimaryKeySelective(TBookModel model);

    int deleteOne(int id);
}
