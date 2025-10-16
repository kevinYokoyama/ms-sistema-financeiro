package com.example.FinancialSystem.core.domain;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
