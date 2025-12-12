package com.example.FinancialSystem.entryPoint.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CustomerDto {

    @NotNull(message = "Name cannot be null")
    @Schema(description = "Name of the customer", example = "Kevin")
    private String name;

    @NotNull(message = "Document cannot be null")
    @Schema(description = "Document of the customer", example = "111.222.333-44")
    private String document;

    @NotNull(message = "Birthdate cannot be null")
    @Schema(description = "Birthdate of the customer", example = "2009-03-01")
    private LocalDate birthdate;

    @NotNull(message = "Zipcode cannot be null")
    @Schema(description = "Zipcode of the customer", example = "12345-000")
    private String zipcode;
}
