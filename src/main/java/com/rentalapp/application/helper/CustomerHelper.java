package com.rentalapp.application.helper;

import com.rentalapp.application.model.CustomerRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.model.CustomerModel;

public interface CustomerHelper {

	/* リクエストからモデルへ。 */
	CustomerModel toCustomerModel(CustomerRequest req);

	/* モデルからレスポンスへ。 */
	CustomerResponse toCustomerResponse(CustomerModel model);

}
