package com.rentalapp.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 顧客APIレスポンス.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersResponse {
    private List<CustomerResponse> customers;
    private int count;
}
