package com.antonio.cleanarch.core.dataprovider;

import com.antonio.cleanarch.core.domain.Customer;
import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);

}
