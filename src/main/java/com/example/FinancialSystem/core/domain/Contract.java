package com.example.FinancialSystem.core.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    public Contract (String id, ContractStatus status, Customer customer, BigDecimal requestAmount, BigDecimal totalAmount, BigDecimal installmentAmount, LocalDate startDate, LocalDate endDate, Integer daysOverdue, BigDecimal monthlySetRate){
        this.id=id;
        this.status=status;
        this.customer=customer;
        this.requestAmount=requestAmount;
        this.totalAmount=totalAmount;
        this.installmentAmount=installmentAmount;
        this.startDate=startDate;
        this.endDate=endDate;
        this.daysOverdue=daysOverdue;
        this.monthlySetRate=monthlySetRate;
    }
}
