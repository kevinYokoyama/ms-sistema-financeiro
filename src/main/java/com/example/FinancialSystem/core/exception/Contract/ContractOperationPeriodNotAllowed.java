package com.example.FinancialSystem.core.exception.Contract;

import org.apache.coyote.BadRequestException;

public class ContractOperationPeriodNotAllowed extends BadRequestException {
    public ContractOperationPeriodNotAllowed() {
        super("Operation period must be positive");
    }
}
