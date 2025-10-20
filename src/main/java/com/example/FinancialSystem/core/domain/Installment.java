package com.example.FinancialSystem.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class Installment {

    private String id;

    private LocalDate paymentDueDate;

    private BigDecimal totalAmount;

    private InstallmentStatus status;
}
