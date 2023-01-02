package com.antonio.cleanarch.entrypoint.controller.response;

import lombok.Builder;

@Builder
public record AddressResponse(
        String street,
        String city,
        String state
) {
}
