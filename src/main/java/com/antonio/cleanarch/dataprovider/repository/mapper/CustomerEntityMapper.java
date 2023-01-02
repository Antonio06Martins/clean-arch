package com.antonio.cleanarch.dataprovider.repository.mapper;

import com.antonio.cleanarch.core.domain.Customer;
import com.antonio.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
//http://localhost:8085/
//http://localhost:19000/

//java -jar wiremock-jre8-standalone-2.35.0.jar --port 8082