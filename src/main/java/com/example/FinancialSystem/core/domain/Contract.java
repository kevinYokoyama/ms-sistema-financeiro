package com.example.FinancialSystem.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class Contract {

    private String id;

    private ContractStatus status;

    private Customer customer;

    private BigDecimal requestAmount;

    private BigDecimal totalAmount;

    private BigDecimal installmentAmount;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer daysOverdue;

    private BigDecimal monthlySetRate;
}
