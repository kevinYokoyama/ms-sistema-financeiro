package com.example.FinancialSystem.dataProvider.dto;

public record ViaCepResponse(String zipcode, String logradouro, String bairro, String complemento,
                             String unidade, String localidade, String uf, String estado) {
}
