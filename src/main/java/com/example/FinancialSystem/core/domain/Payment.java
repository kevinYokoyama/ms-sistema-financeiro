package com.example.FinancialSystem.core.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Payment {

    private Double amoutPaid;

    private Double remainingAmount;

    private LocalDate datePayment;

    private PaymentMethod paymentMethod;

    private Installment installment;

    public Payment(Double amoutPaid, Double remainingAmount, PaymentMethod paymentMethod, Installment installment){
        this.amoutPaid=amoutPaid;
        this.remainingAmount=remainingAmount;
        this.datePayment=LocalDate.now();
        this.paymentMethod=paymentMethod;
        this.installment=installment;
    }
}
