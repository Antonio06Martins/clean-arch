package com.antonio.cleanarch.entrypoint.consumer;

import com.antonio.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.antonio.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.antonio.cleanarch.entrypoint.consumer.message.CustomerMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerUseCase updateCustomerUseCase;

    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "martins")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }

}


