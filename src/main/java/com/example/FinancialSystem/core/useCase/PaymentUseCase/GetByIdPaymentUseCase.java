package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class GetByIdPaymentUseCase {

    public Payment execute(String id) {
        var payment1 = Payment.builder()
                .id("1")
                .amountPaid(BigDecimal.valueOf(1000))
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .status(PaymentStatus.EXECUTED)
                .build();
        var payment2 = Payment.builder()
                .id("2")
                .amountPaid(BigDecimal.valueOf(2000))
                .paymentMethod(PaymentMethod.DEBIT_CARD)
                .status(PaymentStatus.EXECUTED)
                .build();
        var payment3 = Payment.builder()
                .id("3")
                .amountPaid(BigDecimal.valueOf(3000))
                .paymentMethod(PaymentMethod.PIX)
                .status(PaymentStatus.EXECUTED)
                .build();

        if (payment1.getId().equals(id)) {
            return payment1;
        }
        if (payment2.getId().equals(id)) {
            return payment2;
        }
        if (payment3.getId().equals(id)) {
            return payment3;
        }
        return null;
    }
}
