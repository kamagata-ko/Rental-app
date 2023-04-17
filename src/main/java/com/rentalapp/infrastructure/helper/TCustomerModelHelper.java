package com.rentalapp.infrastructure.helper;

import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.infrastructure.model.TCustomerModel;

/**
 * 顧客情報ヘルパーインターフェース.
 */
public interface TCustomerModelHelper {

	/**
	 * ドメイン層顧客モデルから顧客テーブルモデルへ変換.
	 *
	 * @param model 顧客モデル
	 * @return 顧客テーブルモデル
	 */
	TCustomerModel toTableModel(CustomerModel model);

	/**
	 * 顧客テーブルモデルからドメイン層顧客モデルへ変換.
	 *
	 * @param model 顧客テーブルモデル
	 * @return 顧客モデル
	 */
	CustomerModel toModel(TCustomerModel model);

}
