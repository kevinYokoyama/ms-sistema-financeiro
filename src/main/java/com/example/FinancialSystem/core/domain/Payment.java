package com.example.FinancialSystem.core.domain;

import java.time.LocalDate;

public class Payment {
    private Double amoutPaid;
    private Double remainingAmount;
    private LocalDate datePayment;
    private PaymentMethod paymentMethod;
    private Installment installment;
}
