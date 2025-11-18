package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractDaysOverdueNotFoundException extends BadRequestException {
    public ContractDaysOverdueNotFoundException() {
        super("Days overdue from Contract not found");
    }
}
