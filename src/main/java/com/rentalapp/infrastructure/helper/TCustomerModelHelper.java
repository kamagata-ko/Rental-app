package com.rentalapp.infrastructure.helper;

import com.rentalapp.infrastructure.model.TCustomerModel;
import com.rentalapp.model.CustomerModel;

public interface TCustomerModelHelper {

	/* モデルから テーブルモデルへ。※実装は後ほど・・・ */
	public TCustomerModel toTableModel(CustomerModel model);

	/* テーブルモデルから モデルへ。※実装は後ほど・・・ */
	public CustomerModel toModel(TCustomerModel model);

}
