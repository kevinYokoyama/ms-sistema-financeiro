package com.example.FinancialSystem.dataProvider.entity;

import com.example.FinancialSystem.core.domain.enumeration.InstallmentStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Document(collection = "installment")
public class InstallmentEntity {

    @MongoId

    private String id;

    private LocalDate dueDate;

    private BigDecimal totalAmount;

    private InstallmentStatus status;
}
