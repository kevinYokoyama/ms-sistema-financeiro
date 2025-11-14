package com.example.FinancialSystem.entryPoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
public class ContractDto {

    @NotNull(message = "Request amount cannot be null")
    private BigDecimal requestAmount;

    @NotNull(message = "Operation period cannot be null")
    private Integer operationPeriod;

    @NotNull(message = "Customer id cannot be null")
    private String customerId;
}
