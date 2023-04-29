package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TBookModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    int insertBook(TBookModel model);

    TBookModel selectOne(Integer id);

    List<TBookModel> select(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("sort") String sort);

    int count();

    int updateByPrimaryKeySelective(TBookModel model);

    int deleteOne(Integer id);
}
