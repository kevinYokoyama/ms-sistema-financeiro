package com.example.FinancialSystem.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Payment {

    private Double amoutPaid;

    private Double remainingAmount;

    private LocalDate datePayment;

    private PaymentMethod paymentMethod;

    private Installment installment;
}
