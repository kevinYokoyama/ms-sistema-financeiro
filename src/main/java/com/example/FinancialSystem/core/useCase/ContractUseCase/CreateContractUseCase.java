package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.Contract.ContractOperationPeriodNotAllowed;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.gateway.GenericGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.FinancialSystem.core.util.ContractUtil.getInstallmentAmount;
import static com.example.FinancialSystem.core.util.ContractUtil.getTotalAmount;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateContractUseCase {

    private final GenericGateway<Contract> contractGateway;

    public Contract execute(Contract contract) throws ContractRequestAmountNotAllowedException, ContractOperationPeriodNotAllowed {

        if (contract.getRequestAmount().compareTo(BigDecimal.valueOf(0)) < 0) {
            log.error("Requested amount not allowed, it must be more than 0");
            throw new ContractRequestAmountNotAllowedException();
        }

        if (contract.getOperationPeriod() < 0) {
            log.error("Operation period must be more than 0");
            throw new ContractOperationPeriodNotAllowed();
        }


        var monthlySetRate = BigDecimal.valueOf(1.25);
        var totalAmount = getTotalAmount(contract, monthlySetRate);
        var installmentAmount = getInstallmentAmount(contract, totalAmount);
        var endDate = LocalDate.now().plusMonths(contract.getOperationPeriod());
        var daysOverdue = 0;

        contract.setOperationPeriod(contract.getOperationPeriod());
        contract.setStatus(ContractStatus.ACTIVE);
        contract.setCustomer(contract.getCustomer());
        contract.setTotalAmount(totalAmount);
        contract.setInstallmentAmount(installmentAmount);
        contract.setStartDate(LocalDate.now());
        contract.setEndDate(endDate);
        contract.setDaysOverdue(daysOverdue);
        contract.setMonthlySetRate(monthlySetRate);
        contract.setRemainingAmount(totalAmount);

        return contractGateway.save(contract);
    }

    private static Customer getCustomer(Contract contract) {
        return Customer.builder().id(contract.getId()).build();
    }

}
