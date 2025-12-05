package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteContractUseCase {

    private final GenericGateway<Contract> contractGateway;

    public void execute(String id) throws ContractIdNotFoundException {

        if (!contractGateway.existById(id)) {
            log.error("Id not found");
            throw new ContractIdNotFoundException(id);
        }
        contractGateway.delete(id);
    }
}