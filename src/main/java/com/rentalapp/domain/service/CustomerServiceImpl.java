package com.rentalapp.domain.service;

import com.rentalapp.domain.model.CustomerModel;
import com.rentalapp.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 顧客情報サービス実装クラス.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    /* 顧客リポジトリ */
    private final CustomerRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(CustomerModel model) {
        return repository.insert(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerModel selectOne(int id) {
        return repository.selectOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerModel> selectAll(int limit, int offset, String sort) {
        return repository.selectAll(limit, offset, sort);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(CustomerModel model) {
        return repository.updateByPrimaryKeySelective(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteOne(int id) {
        return repository.deleteOne(id);
    }
}
