package com.example.FinancialSystem.core.exception.Contract;

import org.apache.coyote.BadRequestException;

public class ContractRequestAmountNotAllowedException extends BadRequestException {
    public ContractRequestAmountNotAllowedException() {
        super("Requested amount needs to be more than R$500,00");
    }
}
