package com.antonio.cleanarch.dataprovider.client;

import com.antonio.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.antonio.cleanarch.core.domain.Address;
import com.antonio.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindAddressByZipCodeimpl implements FindAddressByZipCode {

    private final FindAddressByZipCodeClient client;

    private final AddressResponseMapper addressResponseMapper;

    public Address find(String zipCode) {
        var addressResponse = client.getAddress(zipCode);
        log.info("Endereço [{}]", addressResponse);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
