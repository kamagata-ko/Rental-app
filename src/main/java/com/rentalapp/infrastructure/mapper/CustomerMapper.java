package com.rentalapp.infrastructure.mapper;

import com.rentalapp.infrastructure.model.TCustomerModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 顧客マッパーインターフェース。
 */
@Mapper
public interface CustomerMapper {
    /**
     * 顧客情報登録処理。
     *
     * @param model 顧客テーブルモデル
     * @return 登録件数
     */
    int insert(TCustomerModel model);

    /**
     * 顧客情報取得（１件）。
     *
     * @param id ID
     * @return 顧客情報（１件）
     */
    TCustomerModel selectOne(int id);

    /**
     * 顧客情報取得.
     *
     * @param limit  取得件数
     * @param offset 取得開始位置
     * @param sort   ソート条件
     * @return 顧客情報
     */
    List<TCustomerModel> select(
            @Param("limit") int limit,
            @Param("offset") int offset,
            @Param("sort") String sort);

    int count();

    /**
     * 顧客情報更新処理。
     *
     * @param model 顧客テーブルモデル
     * @return 更新件数
     */
    int updateByPrimaryKeySelective(TCustomerModel model);

    /**
     * 顧客情報削除処理（論理削除）。
     *
     * @param id ID
     * @return 削除件数
     */
    int deleteOne(int id);

}
