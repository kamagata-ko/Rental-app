package com.rentalapp.domain.service;

import com.rentalapp.domain.info.RentalInfo;
import com.rentalapp.domain.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository repository;

    @Override
    public int doRental(RentalInfo info) {
        return repository.doRental(info);
    }
}
