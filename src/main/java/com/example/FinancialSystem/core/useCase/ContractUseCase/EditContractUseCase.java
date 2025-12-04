package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.exception.Contract.ContractOperationPeriodNotAllowed;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.FinancialSystem.core.util.ContractUtil.getInstallmentAmount;
import static com.example.FinancialSystem.core.util.ContractUtil.getTotalAmount;

@Slf4j
@Component
@RequiredArgsConstructor
public class EditContractUseCase {

    private final GenericGateway<Contract> contractGateway;

    private final GetByIdContractUseCase getByIdContractUseCase;

    public Contract execute(String id, Contract contract) throws ContractRequestAmountNotAllowedException, ContractIdNotFoundException, ContractOperationPeriodNotAllowed {

        if (contract.getRequestAmount().compareTo(BigDecimal.valueOf(0)) <= 0) {
            log.error("Requested amount not allowed, it must be more than 0");
            throw new ContractRequestAmountNotAllowedException();
        }
        if (contract.getOperationPeriod() <= 0) {
            log.error("Operation period not allowed, it must be more than 0");
            throw new ContractOperationPeriodNotAllowed();
        }
        var saved = getByIdContractUseCase.execute(id);


        var totalAmount = getTotalAmount(contract, saved.getMonthlySetRate());
        var installmentAmount = getInstallmentAmount(contract, totalAmount);

        saved.setRemainingAmount(contract.getRemainingAmount());
        saved.setRequestAmount(contract.getRequestAmount());
        saved.setOperationPeriod(contract.getOperationPeriod());
        saved.setTotalAmount(totalAmount);
        saved.setInstallmentAmount(installmentAmount.setScale(2, RoundingMode.HALF_UP));

        return contractGateway.save(saved);
    }
}
