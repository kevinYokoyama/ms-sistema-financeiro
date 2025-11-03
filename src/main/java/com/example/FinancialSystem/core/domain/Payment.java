package com.example.FinancialSystem.core.domain;

import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Payment {

    private String id;

    private BigDecimal amountPaid;

    private LocalDate datePayment;

    private PaymentMethod paymentMethod;

    private Installment installment;

    private PaymentStatus status;
}
