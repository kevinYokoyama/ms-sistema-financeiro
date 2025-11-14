package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractRequestAmountNotFoundException extends BadRequestException {
    public ContractRequestAmountNotFoundException() {
        super("Requested amount value from Contract not found");
    }
}
