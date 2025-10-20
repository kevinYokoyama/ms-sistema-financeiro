package com.example.FinancialSystem.core.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class Installment {

    private String id;

    private LocalDate paymentDueDate;

    private BigDecimal totalAmount;

    private Contract contract;

    private InstallmentStatus status;

    public Installment (String id, LocalDate paymentDueDate, BigDecimal totalAmount, Contract contract, InstallmentStatus status){
        this.id=id;
        this.paymentDueDate=paymentDueDate;
        this.totalAmount=totalAmount;
        this.contract=contract;
        this.status=status;
    }
}
