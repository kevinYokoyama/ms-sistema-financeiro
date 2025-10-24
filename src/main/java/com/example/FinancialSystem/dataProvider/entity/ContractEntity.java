package com.example.FinancialSystem.dataProvider.entity;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Document(collection = "contract")
public class ContractEntity {

    @MongoId
    private String id;

    private ContractStatus status;

    private Customer customer;

    private BigDecimal requestAmount;

    private BigDecimal totalAmount;

    private BigDecimal installmentAmount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private Integer daysOverdue;

    private BigDecimal monthlySetRate;

    private BigDecimal remainingAmount;

    private List<InstallmentEntity> installments;
}
