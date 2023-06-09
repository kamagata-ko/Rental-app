package com.rentalapp.domain.service;

import com.rentalapp.domain.model.CustomerModel;

import java.util.List;

/**
 * 顧客情報サービスインターフェース.
 */
public interface CustomerService {

    /**
     * 顧客情報登録処理.
     *
     * @param model 顧客モデル
     * @return 登録件数
     */
    int insert(CustomerModel model);

    /**
     * 顧客情報取得処理（１件）.
     *
     * @param id ID
     * @return 顧客情報（１件）
     */
    CustomerModel selectOne(int id);

    /**
     * 顧客情報取得.
     *
     * @param limit  取得件数
     * @param offset 取得開始位置
     * @param sort   ソート条件
     * @return 顧客情報
     */
    List<CustomerModel> select(int limit, int offset, String sort);

    int count();

    /**
     * 顧客情報更新処理.
     *
     * @param model 顧客モデル
     * @return 更新件数
     */
    int update(CustomerModel model);

    /**
     * 顧客情報削除処理（論理削除）.
     *
     * @param id ID
     * @return 削除件数
     */
    int deleteOne(int id);
}
