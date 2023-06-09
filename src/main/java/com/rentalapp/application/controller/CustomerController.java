package com.rentalapp.application.controller;

import com.rentalapp.application.api.CustomerApi;
import com.rentalapp.application.helper.CustomerHelper;
import com.rentalapp.application.model.CustomerCreateRequest;
import com.rentalapp.application.model.CustomerResponse;
import com.rentalapp.application.model.CustomerUpdateRequest;
import com.rentalapp.application.model.CustomersResponse;
import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 顧客APIコントローラー.
 */
@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerApi {

    /* 顧客サービス */
    private final CustomerService service;

    /* 顧客ヘルパー */
    private final CustomerHelper helper;

    /**
     * {@inheritDoc}
     */
    @Override
    public int insertCustomer(CustomerCreateRequest request) {
        return service.insert(helper.toModel(request));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerResponse selectOne(String id) {
        CustomerModel result = service.selectOne(Integer.parseInt(id));
        return helper.toResponse(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomersResponse select(Integer limit, Integer offset, String sort) {
        List<CustomerResponse> list = new ArrayList<>();
        List<CustomerModel> result = service.select(limit, offset, sort);
        // めも：ほんとはこんな感じで作ったUtilクラスでやってみたい。int Integer と Object 周りがよくわからない、
        //		List<CustomerModel> result = service.select(
        //				defaultValue(limit, 10),
        //				defaultValue(offset, 0),
        //				defaultValue(sort, "id acs"));
        for (CustomerModel tableModel : result) {
            list.add(helper.toResponse(tableModel));
        }
        int count = service.count();

        return CustomersResponse.builder()
                .customers(list)
                .count(count)
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(int id, CustomerUpdateRequest request) {
        CustomerModel model = helper.toModel(request, id);
        return service.update(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteOne(int id) {
        return service.deleteOne(id);
    }
}
