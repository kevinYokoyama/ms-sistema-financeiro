package com.example.FinancialSystem.core.useCase.ContractUseCase;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class CreateContractUseCase {

    private final ContractGateway contractGateway;

    public Contract execute(Contract contract) {

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

        System.out.print("\nCreating a customer...");

        return contractGateway.save(contract);
    }

    private static BigDecimal getTotalAmount(Contract contract, BigDecimal monthlySetRate) {
        return contract.getRequestAmount().multiply(monthlySetRate).multiply(BigDecimal.valueOf(contract.getOperationPeriod()));
    }

    private static BigDecimal getInstallmentAmount(Contract contract, BigDecimal totalAmount) {
        return totalAmount.divide(BigDecimal.valueOf(contract.getOperationPeriod()));
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
