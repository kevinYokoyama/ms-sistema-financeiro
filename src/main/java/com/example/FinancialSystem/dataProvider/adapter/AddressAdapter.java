package com.example.FinancialSystem.dataProvider.adapter;

import com.example.FinancialSystem.core.exception.Customer.CustomerZipCodeNotFoundException;
import com.example.FinancialSystem.dataProvider.client.ViaCepClient;
import com.example.FinancialSystem.dataProvider.dto.ViaCepResponse;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AddressAdapter {

    private final ViaCepClient client;

    @Retry(name = "addressAdapterRetry", fallbackMethod = "getAddressFallBack")
    public ViaCepResponse getAddress(String zipCode) {
        return client.getViaCep(zipCode);
    }

    public ViaCepResponse getAddressFallBack(String zipCode) throws CustomerZipCodeNotFoundException {
        log.error("Zipcode {} not found", zipCode);
        throw new CustomerZipCodeNotFoundException(zipCode);
    }
}

