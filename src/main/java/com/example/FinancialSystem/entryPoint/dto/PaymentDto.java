package com.example.FinancialSystem.entryPoint.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    @NotNull(message = "Amount paid cannot be null")
    @Schema(description = "Amount paid of the payment", example = "14991.41")
    private BigDecimal amountPaid;

    @NotNull(message = "Payment method cannot be null")
    @Schema(description = "Payment method can be PIX, credit card or debit card", example = "CREDIT_CARD")
    private String paymentMethod;

    @NotNull(message = "Installment cannot be null")
    @Schema(description = "Id of the installment paid", example = "0002")
    private String installmentId;
}
