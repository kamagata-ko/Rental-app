package com.rentalapp.application.helper;

import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
import com.rentalapp.model.CustomerModel;
import org.springframework.stereotype.Component;

/**
 * 顧客APIヘルパー実装クラス.
 */
@Component
public class CustomerHelperImpl implements CustomerHelper {

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerModel toCustomerModel(CustomerCreateRequest req) {
        return CustomerModel.builder()
                .password(req.password())
                .name(req.name())
                .sex(req.sex())
                .birthday(req.birthday())
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerModel toCustomerModel(CustomerUpdateRequest req, int id) {
        return CustomerModel.builder()
                .id(id)
                .password(req.password())
                .name(req.name())
                .sex(req.sex())
                .birthday(req.birthday())
                .updateDate(req.updateDate())
                .deleteFlg(req.deleteFlg())
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerResponse toCustomerResponse(CustomerModel model) {
        CustomerResponse res = new CustomerResponse();
        res.setId(model.getId());
        res.setPassword(model.getPassword());
        res.setName(model.getName());
        res.setSex(model.getSex());
        res.setBirthday(model.getBirthday());
        res.setRegisterDate(model.getRegisterDate());
        res.setUpdateDate(model.getUpdateDate());
        return res;
    }

}
