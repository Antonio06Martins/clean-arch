package com.antonio.cleanarch.core.dataprovider;

import com.antonio.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);

}
