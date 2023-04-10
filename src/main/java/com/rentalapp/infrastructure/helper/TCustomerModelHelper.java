package com.rentalapp.infrastructure.helper;

import com.rentalapp.infrastructure.model.TCustomerModel;
import com.rentalapp.model.CustomerModel;

public interface TCustomerModelHelper {

	/* モデルから テーブルモデルへ。 */
	TCustomerModel toTableModel(CustomerModel model);

	/* テーブルモデルから モデルへ。 */
	CustomerModel toModel(TCustomerModel model);

}
