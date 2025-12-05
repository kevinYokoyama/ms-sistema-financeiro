package com.example.FinancialSystem.entryPoint.worker;

import com.example.FinancialSystem.core.exception.Customer.CustomerBirthdateNotAllowed;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.CreateCustomerUseCase;
import com.example.FinancialSystem.entryPoint.dto.CustomerDto;
import com.example.FinancialSystem.entryPoint.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class CreateCustomerConsumer {

    private final CustomerMapper customerMapper;

    private final CreateCustomerUseCase createCustomerUseCase;

    @Bean
    Consumer<Message<CustomerDto>> createCustomerEvent() {
        return this::receive;
    }

    public void receive(Message<CustomerDto> message) {
        try {
            var customer = customerMapper.toDomain(message.getPayload());
            createCustomerUseCase.execute(customer);
        } catch (CustomerBirthdateNotAllowed e) {
            throw new RuntimeException(e);
        }
    }
}