package com.example.FinancialSystem.entryPoint.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CustomerDto {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Birthdate cannot be null")
    private LocalDate birthdate;
}
