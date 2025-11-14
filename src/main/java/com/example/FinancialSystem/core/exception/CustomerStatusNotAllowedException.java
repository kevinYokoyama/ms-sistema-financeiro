package com.example.FinancialSystem.core.exception;

import org.apache.coyote.BadRequestException;

public class CustomerStatusNotAllowedException extends BadRequestException {

    public CustomerStatusNotAllowedException() {
        super("Status from Customer not Allowed. It needs to be ACRIVE, BLOCKED or INACTIVE");
    }
}
