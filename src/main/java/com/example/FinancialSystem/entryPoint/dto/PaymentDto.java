package com.example.FinancialSystem.entryPoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    @NotNull(message = "Amount paid cannot be null")
    private BigDecimal amountPaid;

    @NotNull(message = "Payment method cannot be null")
    private String paymentMethod;

    @NotNull(message = "Installment cannot be null")
    private String installmentId;
}
