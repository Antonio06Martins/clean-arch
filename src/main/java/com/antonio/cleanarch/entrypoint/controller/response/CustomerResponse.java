package com.antonio.cleanarch.entrypoint.controller.response;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String name,
        String cpf,
        Boolean isValidCpf,
        AddressResponse address
) {
}

