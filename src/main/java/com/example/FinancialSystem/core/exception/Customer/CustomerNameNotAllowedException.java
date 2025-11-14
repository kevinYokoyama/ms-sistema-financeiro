package com.example.FinancialSystem.core.exception.Customer;

import org.apache.coyote.BadRequestException;

public class CustomerNameNotAllowedException extends BadRequestException {
    public CustomerNameNotAllowedException(String name) {
        super("Name '" + name + "' from Customer not allowed because its the same as it was");
    }
}
