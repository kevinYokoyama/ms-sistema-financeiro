package com.example.FinancialSystem.core.exception.Contract;

import org.apache.coyote.BadRequestException;

public class ContractDaysOverdueNotFoundException extends BadRequestException {
    public ContractDaysOverdueNotFoundException() {
        super("Days overdue from Contract not found");
    }
}
