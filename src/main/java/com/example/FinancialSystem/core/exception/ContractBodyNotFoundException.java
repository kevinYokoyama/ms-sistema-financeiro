package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractBodyNotFoundException extends BadRequestException {
    public ContractBodyNotFoundException() {
        super("Body not found");
    }
}
