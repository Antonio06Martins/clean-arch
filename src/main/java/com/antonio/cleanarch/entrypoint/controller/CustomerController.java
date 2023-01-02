package com.antonio.cleanarch.entrypoint.controller;

import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.antonio.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.antonio.cleanarch.core.usecase.InsertCustomerUseCase;
import com.antonio.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.antonio.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.antonio.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.antonio.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase insertCustomerUseCase;

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final UpdateCustomerUseCase updateCustomerUseCase;

    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.zipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id); //remover para teste essa linha
        updateCustomerUseCase.update(customer, customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}