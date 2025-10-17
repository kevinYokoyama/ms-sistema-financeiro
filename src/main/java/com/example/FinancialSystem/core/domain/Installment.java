package com.example.FinancialSystem.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
    private String id;
    private LocalDate dataVendicemnto;
    private BigDecimal totalAmount;
    private Contract contract;
    private InstallmentStatus status;

}
