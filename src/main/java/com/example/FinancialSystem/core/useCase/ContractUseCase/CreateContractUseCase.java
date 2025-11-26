package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.FinancialSystem.core.util.ContractUtil.getInstallmentAmount;
import static com.example.FinancialSystem.core.util.ContractUtil.getTotalAmount;


@Component
@RequiredArgsConstructor
public class CreateContractUseCase {

    private final ContractGateway contractGateway;

    public Contract execute(Contract contract) throws ContractRequestAmountNotAllowedException {

        if (contract.getRequestAmount().compareTo(BigDecimal.valueOf(0)) == 0) {
            throw new ContractRequestAmountNotAllowedException();
        }

        var monthlySetRate = BigDecimal.valueOf(1.25);
        var totalAmount = getTotalAmount(contract, monthlySetRate);
        var installmentAmount = getInstallmentAmount(contract, totalAmount);
        var endDate = LocalDate.now().plusMonths(contract.getOperationPeriod());
        var customer = getCustomer(contract);
        var daysOverdue = getDaysOverdue(endDate);

        contract.setStatus(ContractStatus.ACTIVE);
        contract.setCustomer(customer);
        contract.setTotalAmount(totalAmount);
        contract.setInstallmentAmount(installmentAmount);
        contract.setStartDate(LocalDate.now());
        contract.setEndDate(endDate);
        contract.setDaysOverdue(daysOverdue);
        contract.setMonthlySetRate(monthlySetRate);
        contract.setRemainingAmount(getRemainingAmount(totalAmount, installmentAmount));

        return contractGateway.save(contract);
    }

    private static Customer getCustomer(Contract contract) {
        return Customer.builder().id(contract.getId()).build();
    }

    private static int getDaysOverdue(LocalDate endDate) {
        return endDate.getDayOfMonth();
    }

    private static BigDecimal getRemainingAmount(BigDecimal totalAmount, BigDecimal installmentAmount) {
        return totalAmount.subtract(installmentAmount);
    }
}
