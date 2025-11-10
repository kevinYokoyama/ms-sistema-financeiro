package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractIdNotFoundException extends BadRequestException {
    public ContractIdNotFoundException() {
        super("Id not found");
    }
}
