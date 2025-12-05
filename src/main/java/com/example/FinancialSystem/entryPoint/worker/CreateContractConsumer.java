package com.example.FinancialSystem.entryPoint.worker;

import com.example.FinancialSystem.core.exception.Contract.ContractOperationPeriodNotAllowed;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.useCase.ContractUseCase.CreateContractUseCase;
import com.example.FinancialSystem.entryPoint.dto.ContractDto;
import com.example.FinancialSystem.entryPoint.mapper.ContractMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class CreateContractConsumer {

    private final ContractMapper contractMapper;

    private final CreateContractUseCase createContractUseCase;

    @Bean
    Consumer<Message<ContractDto>> createContractEvent() {
        return this::receive;
    }

    public void receive(Message<ContractDto> message) {
        try {
            var contract = contractMapper.toDomain(message.getPayload());
            createContractUseCase.execute(contract);
        } catch (ContractOperationPeriodNotAllowed | ContractRequestAmountNotAllowedException e) {
            throw new RuntimeException(e);
        }
    }
}