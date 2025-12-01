package com.example.FinancialSystem.entryPoint.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ContractDto {

    @NotNull(message = "Request amount cannot be null")
    @Schema(description = "Requested amount of the contract", example = "200.10")
    private BigDecimal requestAmount;

    @NotNull(message = "Operation period cannot be null")
    @Schema(description = "Operation period is the total time the customer pays for service", example = "3")
    private Integer operationPeriod;

    @NotNull(message = "Customer id cannot be null")
    @Schema(description = "Id of the customer", example = "abcdefghijklmnopqrstuvwxyz123")
    private String customerId;
}
