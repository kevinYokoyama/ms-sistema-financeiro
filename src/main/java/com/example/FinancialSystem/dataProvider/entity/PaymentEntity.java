package com.example.FinancialSystem.dataProvider.entity;

import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Document(collection = "payment")
public class PaymentEntity {

    @MongoId

    private String id;

    private BigDecimal amountPaid;

    private LocalDate datePayment;

    private PaymentMethod paymentMethod;

    private InstallmentEntity installment;

    private PaymentStatus status;
}
