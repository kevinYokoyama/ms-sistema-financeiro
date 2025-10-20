package com.example.FinancialSystem.core.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Customer {

    private String id;

    private String name;

    private String document;

    private LocalDate birthdate;

    private CustomerStatus status;

    public Customer(String id, String name, String document, LocalDate birthdate, CustomerStatus status){
        this.id=id;
        this.name=name;
        this.document=document;
        this.birthdate=birthdate;
        this.status=status;
    }
}
