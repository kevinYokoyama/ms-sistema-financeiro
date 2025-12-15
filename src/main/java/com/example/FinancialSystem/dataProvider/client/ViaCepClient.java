package com.example.FinancialSystem.dataProvider.client;

import com.example.FinancialSystem.dataProvider.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepFeign", url = "${sgep.viaCep.url}")
public interface ViaCepClient {

    @GetMapping("/{zipcode}/json")
    ViaCepResponse getViaCep(@PathVariable String zipcode);
}
