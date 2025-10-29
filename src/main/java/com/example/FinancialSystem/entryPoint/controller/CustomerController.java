package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer create() {
        System.out.print("\nCreating a customer...");
        return null;
    }

    @PutMapping("/{name}")
    public Customer edit(@PathVariable String name) {
        System.out.printf("\nEditing the name: %s", name);
        return null;
    }

    @GetMapping("/{id}")
    public List<Customer> get(@PathVariable String id) {
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }

    @DeleteMapping("/{id}")
    public List<Customer> delete(@PathVariable String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
