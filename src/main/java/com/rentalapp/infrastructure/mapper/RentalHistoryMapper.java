package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TRentalModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RentalHistoryMapper {
    int insert(TRentalModel model);

    /**
     * 指定したIDによって履歴情報を取得する。
     *
     * @param id      （履歴ID・顧客ID・本ID）のいずれか。
     * @param pattern パターン（1:履歴ID・2:顧客ID・3:本ID）
     * @return 履歴情報。
     */
    List<TRentalModel> selectById(Integer id, int pattern);

    List<TRentalModel> selectAll(
            @Param("limit") int limit,
            @Param("offset") int offset,
            @Param("sort") String sort);

    int delete(Integer id);
}
