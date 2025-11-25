package com.example.FinancialSystem.core.util;

import com.example.FinancialSystem.core.domain.Contract;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class ContractUtil {

    public static BigDecimal getTotalAmount(Contract contract, BigDecimal monthlySetRate) {
        return contract.getRequestAmount().multiply(monthlySetRate).multiply(BigDecimal.valueOf(contract.getOperationPeriod()));
    }

    public static BigDecimal getInstallmentAmount(Contract contract, BigDecimal totalAmount) {
        return totalAmount.divide(BigDecimal.valueOf(contract.getOperationPeriod()));
    }


}
