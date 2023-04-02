package com.rentalapp.domain.service;

import com.rentalapp.domain.repository.CustomerRepository;
import com.rentalapp.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public int insert(CustomerModel model) {
        return repository.insert(model);
    }

    @Override
    public CustomerModel selectOne(String id) {
        return repository.selectOne(id);
    }

    @Override
    public List<CustomerModel> selectAll() {
        return repository.selectAll();
    }

    @Override
    public int update(CustomerModel model) {
        return repository.updateByPrimaryKeySelective(model);
    }
}
