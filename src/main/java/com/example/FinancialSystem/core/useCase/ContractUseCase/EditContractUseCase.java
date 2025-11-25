package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.FinancialSystem.core.util.ContractUtil.getInstallmentAmount;
import static com.example.FinancialSystem.core.util.ContractUtil.getTotalAmount;

@Component
@RequiredArgsConstructor
public class EditContractUseCase {

    private final ContractGateway contractGateway;

    private final GetByIdContractUseCase getByIdContractUseCase;

    public Contract execute(String id, Contract contract) throws ContractRequestAmountNotAllowedException, ContractIdNotFoundException {

        if (!contractGateway.existById(contract.getId())) {
            throw new ContractIdNotFoundException(contract.getId());
        }
        if (contract.getRequestAmount().compareTo(BigDecimal.valueOf(500)) < 0) {
            throw new ContractRequestAmountNotAllowedException();
        }

        var saved = getByIdContractUseCase.execute(id);


        var totalAmount = getTotalAmount(contract, saved.getMonthlySetRate());
        var installmentAmount = getInstallmentAmount(contract, totalAmount);

        saved.setRemainingAmount(contract.getRemainingAmount());
        saved.setCustomer(contract.getCustomer());
        saved.setOperationPeriod(contract.getOperationPeriod());
        saved.setInstallmentAmount(installmentAmount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Editing the requested amount to " + contract.getRequestAmount());

        return saved;
    }
}
