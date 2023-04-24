package com.rentalapp.domain.repository;

import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.infrastructure.helper.TCustomerModelHelper;
import com.rentalapp.infrastructure.mapper.CustomerMapper;
import com.rentalapp.infrastructure.model.TCustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 顧客情報リポジトリ実装クラス.
 */
@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    /* 顧客マッパー */
    private final CustomerMapper mapper;

    /* 顧客ヘルパー */
    private final TCustomerModelHelper helper;

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(CustomerModel model) {
        LocalDateTime ldt = LocalDateTime.now();
        model.setRegisterDate(ldt);
        model.setUpdateDate(ldt);
        return mapper.insert(helper.toTableModel(model));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerModel selectOne(int id) {
        TCustomerModel result = mapper.selectOne(id);
        return helper.toModel(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerModel> selectAll(int limit, int offset, String sort) {
        return mapper.select(limit, offset, sort)
                .stream()
                .map(helper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return mapper.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateByPrimaryKeySelective(CustomerModel model) {
        LocalDateTime ldt = LocalDateTime.now();
        model.setUpdateDate(ldt);
        return mapper.updateByPrimaryKeySelective(helper.toTableModel(model));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteOne(int id) {
        return mapper.deleteOne(id);
    }

}
