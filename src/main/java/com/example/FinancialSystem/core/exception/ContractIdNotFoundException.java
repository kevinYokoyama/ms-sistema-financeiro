package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractIdNotFoundException extends BadRequestException {
    public ContractIdNotFoundException(String id) {
        super("Contract from the Id " + id + " not found");
    }
}
