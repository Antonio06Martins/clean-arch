package com.antonio.cleanarch.core.usecase;

import com.antonio.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipCode);

}
