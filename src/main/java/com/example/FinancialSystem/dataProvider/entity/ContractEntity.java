package com.example.FinancialSystem.dataProvider.entity;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer daysOverdue;

    private BigDecimal monthlySetRate;

    private BigDecimal remainingAmount;
}
