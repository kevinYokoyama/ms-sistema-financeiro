package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.domain.enumeration.CustomerStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    public Customer create(@RequestBody Customer customer) {
        System.out.print("\nCreating a customer...");
        return Customer.builder()
                .id(customer.getId())
                .name(customer.getName())
                .birthdate(customer.getBirthdate())
                .status(CustomerStatus.ACTIVE)
                .build();
    }

    @PutMapping
    public Customer edit(@RequestBody Customer customer) {
        var customer2 = Customer.builder()
                .id("1")
                .name("Naomi")
                .status(CustomerStatus.ACTIVE)
                .build();
        System.out.printf("\nEditing the name to %s", customer.getName() );
        return customer2;
    }

    @GetMapping("/{id}")
    public List<Customer> get(@PathVariable String id) {
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public List<Customer> delete(@PathVariable String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}