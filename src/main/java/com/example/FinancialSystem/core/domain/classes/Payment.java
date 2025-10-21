package com.example.FinancialSystem.core.domain.classes;

import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Payment {

    private Double amountPaid;

    private LocalDate datePayment;

    private PaymentMethod paymentMethod;

    private Installment installment;

    private PaymentStatus status;
}
