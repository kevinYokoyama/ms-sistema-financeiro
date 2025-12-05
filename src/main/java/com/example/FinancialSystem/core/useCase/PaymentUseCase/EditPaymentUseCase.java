package com.example.FinancialSystem.core.useCase.PaymentUseCase;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.exception.Payment.PaymentAmountPaidNotAllowdException;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class EditPaymentUseCase {

    private final GenericGateway<Payment> paymentGateway;

    private final GetByIdPaymentUseCase getByIdPaymentUseCase;

    public Payment execute(String id, Payment payment) throws PaymentMethodNotFoundException, PaymentIdNotFoundException, PaymentAmountPaidNotAllowdException {

        if (!payment.getPaymentMethod().equals(PaymentMethod.PIX) && !payment.getPaymentMethod().equals(PaymentMethod.DEBIT_CARD) && !payment.getPaymentMethod().equals(PaymentMethod.CREDIT_CARD)) {
            log.error("The method must be PIX, debit card or credit card");
            throw new PaymentMethodNotFoundException();
        }
        if (payment.getAmountPaid().compareTo(BigDecimal.valueOf(0)) <= 0) {
            log.error("Amount paid not allowed, it must be more than 0");
            throw new PaymentAmountPaidNotAllowdException();
        }
        var saved = getByIdPaymentUseCase.execute(id);

        saved.setStatus(PaymentStatus.EXECUTED);
        saved.setPaymentMethod(payment.getPaymentMethod());

        return paymentGateway.save(saved);
    }
}
