package com.antonio.cleanarch.core.usecase;

import com.antonio.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);

}
