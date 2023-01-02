package com.antonio.cleanarch.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CustomerRequest(

        @NotBlank
        String name,
        @NotBlank
        String cpf,
        @NotBlank
        String zipCode
) {
}
