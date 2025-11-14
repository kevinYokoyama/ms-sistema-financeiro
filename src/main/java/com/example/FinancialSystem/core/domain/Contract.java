package com.example.FinancialSystem.core.domain;

import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Contract {

    private String id;

    private Integer operationPeriod;

    private ContractStatus status;

    private Customer customer;

    private BigDecimal requestAmount;

    private BigDecimal totalAmount;

    private BigDecimal installmentAmount;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer daysOverdue;

    private BigDecimal monthlySetRate;

    private BigDecimal remainingAmount;
}
