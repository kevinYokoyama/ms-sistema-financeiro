package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class ContractIdNotFound extends BadRequestException {
    public ContractIdNotFound() {
        super("ERROR 404: Id not found");
    }
}
