package com.antonio.cleanarch.core.usecase.impl;

import com.antonio.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.antonio.cleanarch.core.dataprovider.UpdateCustomer;
import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.antonio.cleanarch.core.usecase.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final FindAddressByZipCode findAddressByZipCode;

    private final UpdateCustomer updateCustomer;

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.find(customer.getId());
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        updateCustomer.update(customer);
    }

}
