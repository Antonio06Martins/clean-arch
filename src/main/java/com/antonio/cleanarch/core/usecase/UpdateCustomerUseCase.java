package com.antonio.cleanarch.core.usecase;

import com.antonio.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipCode);

}
