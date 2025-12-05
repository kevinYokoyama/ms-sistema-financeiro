package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListContactUseCase {

    private final GenericGateway<Contract> contractGateway;

    public Page<Contract> execute(Pageable pageable) {
        return contractGateway.findAll(pageable);
    }
}
