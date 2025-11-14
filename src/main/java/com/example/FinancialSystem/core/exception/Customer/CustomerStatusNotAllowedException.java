package com.example.FinancialSystem.core.exception.Customer;

import org.apache.coyote.BadRequestException;

public class CustomerStatusNotAllowedException extends BadRequestException {

    public CustomerStatusNotAllowedException() {
        super("Status from Customer not Allowed. It needs to be ACRIVE, BLOCKED or INACTIVE");
    }
}
