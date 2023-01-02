package com.antonio.cleanarch.dataprovider.client;

import com.antonio.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FindAddressByZipCodeClient {

    private final WebClient webClient;
    private static final String ENDERECO = "http://localhost:8082";

        public FindAddressByZipCodeClient(WebClient.Builder webClientBuilder) {
            this.webClient = webClientBuilder
                    .baseUrl(ENDERECO)
                    .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                    .build();

    }

        public AddressResponse getAddress(final String zipCode) {
            return this.webClient.get()
                    .uri("/addresses/{zipCode}", zipCode)
                    .retrieve()
                    .bodyToMono(AddressResponse.class)
                    .block();
    }

}
