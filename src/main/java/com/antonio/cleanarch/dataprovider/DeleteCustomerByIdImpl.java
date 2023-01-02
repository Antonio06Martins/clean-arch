package com.antonio.cleanarch.dataprovider;

import com.antonio.cleanarch.core.dataprovider.DeleteCustomerById;
import com.antonio.cleanarch.dataprovider.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
