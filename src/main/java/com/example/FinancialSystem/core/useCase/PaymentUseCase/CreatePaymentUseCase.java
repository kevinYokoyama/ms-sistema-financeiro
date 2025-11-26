package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Installment;
import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public Payment execute(Payment payment) throws PaymentMethodNotFoundException {

        if (!payment.getPaymentMethod().equals(PaymentMethod.PIX) && !payment.getPaymentMethod().equals(PaymentMethod.DEBIT_CARD) && !payment.getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            log.error("The method must be PIX, debit card or credit card");
            throw new PaymentMethodNotFoundException();
        }

        var installment = Installment.builder().id(payment.getInstallment().getId()).build();

        payment.setAmountPaid(payment.getAmountPaid());
        payment.setDatePayment(LocalDate.now());
        payment.setPaymentMethod(payment.getPaymentMethod());
        payment.setInstallment(installment);
        payment.setStatus(PaymentStatus.EXECUTED);

        return paymentGateway.save(payment);
    }
}
