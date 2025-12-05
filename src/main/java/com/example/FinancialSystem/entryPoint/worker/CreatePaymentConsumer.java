package com.example.FinancialSystem.entryPoint.worker;

import com.example.FinancialSystem.core.exception.Payment.PaymentAmountPaidNotAllowdException;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.CreatePaymentUseCase;
import com.example.FinancialSystem.entryPoint.dto.PaymentDto;
import com.example.FinancialSystem.entryPoint.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class CreatePaymentConsumer {

    private final PaymentMapper paymentMapper;

    private final CreatePaymentUseCase createPaymentUseCase;

    @Bean
    Consumer<Message<PaymentDto>> createPaymentEvent() {
        return this::receive;
    }

    public void receive(Message<PaymentDto> message) {
        try {
            var payment = paymentMapper.toDomain(message.getPayload());
            createPaymentUseCase.execute(payment);
        } catch (PaymentMethodNotFoundException | PaymentAmountPaidNotAllowdException e) {
            throw new RuntimeException(e);
        }
    }
}