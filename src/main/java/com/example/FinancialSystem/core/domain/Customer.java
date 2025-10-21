package com.example.FinancialSystem.core.domain;

import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Customer {

    private String id;

    private String name;

    private String document;

    private LocalDate birthdate;

    private CustomerStatus status;
}
