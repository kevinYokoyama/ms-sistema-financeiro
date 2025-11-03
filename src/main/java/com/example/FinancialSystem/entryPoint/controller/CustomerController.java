package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.CreateCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.DeleteCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.EditCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.GetByIdCustomerUseCase;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final EditCustomerUseCase editCustomerUseCase;
    private final GetByIdCustomerUseCase getByIdCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    public Customer create(@RequestBody Customer customer) {
        return createCustomerUseCase.execute(customer);
    }

    @PutMapping
    public Customer edit(@RequestBody Customer customer) {
        return editCustomerUseCase.execute(customer);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id) {
        return getByIdCustomerUseCase.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        deleteCustomerUseCase.execute(id);
    }
}