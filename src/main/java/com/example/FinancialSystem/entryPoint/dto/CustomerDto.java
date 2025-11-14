package com.example.FinancialSystem.entryPoint.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CustomerDto {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Birthdate cannot be null")
    private LocalDate birthdate;
}
