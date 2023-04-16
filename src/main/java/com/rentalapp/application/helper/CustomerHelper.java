package com.rentalapp.application.helper;

import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
import com.rentalapp.model.CustomerModel;

/**
 * 顧客APIヘルパー
 */
public interface CustomerHelper {

    /**
     * 顧客APIリクエストから顧客モデルへ変換.
     *
     * @param req 顧客APIリクエスト
     * @return 顧客モデル
     */
    CustomerModel toCustomerModel(CustomerCreateRequest req);

    /**
     * 顧客APIリクエストから顧客モデルへ変換.
     *
     * @param req 顧客APIリクエスト
     * @return 顧客モデル
     */
    CustomerModel toCustomerModel(CustomerUpdateRequest req, int id);

    /**
     * 顧客モデルから顧客APIレスポンスへ変換.
     *
     * @param model 顧客モデル
     * @return 顧客APIレスポンス
     */
    CustomerResponse toCustomerResponse(CustomerModel model);

}
