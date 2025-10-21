package com.example.FinancialSystem.core.domain;

import com.example.FinancialSystem.core.domain.enumeration.InstallmentStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class Installment {

    private String id;

    private LocalDate dueDate;

    private BigDecimal totalAmount;

    private InstallmentStatus status;
}
