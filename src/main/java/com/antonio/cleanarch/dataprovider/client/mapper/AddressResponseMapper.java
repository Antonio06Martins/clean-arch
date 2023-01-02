package com.antonio.cleanarch.dataprovider.client.mapper;

import com.antonio.cleanarch.core.domain.Address;
import com.antonio.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
