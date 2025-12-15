package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerBirthdateNotAllowed;
import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.exception.Customer.CustomerNameNotAllowedException;
import com.example.FinancialSystem.core.exception.Customer.CustomerZipCodeNotFoundException;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.CreateCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.DeleteCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.EditCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.GetByIdCustomerUseCase;
import com.example.FinancialSystem.core.useCase.CustomerUseCase.ListCustomerUseCase;
import com.example.FinancialSystem.entryPoint.controller.swagger.CustomerControllerApi;
import com.example.FinancialSystem.entryPoint.dto.CustomerDto;
import com.example.FinancialSystem.entryPoint.mapper.CustomerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
public class CustomerController implements CustomerControllerApi {

    private final CustomerMapper customerMapper;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final EditCustomerUseCase editCustomerUseCase;
    private final GetByIdCustomerUseCase getByIdCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final ListCustomerUseCase listCustomerUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer create(@RequestBody @Valid CustomerDto dto) throws CustomerBirthdateNotAllowed, CustomerZipCodeNotFoundException {
        var customer = customerMapper.toDomain(dto);
        return createCustomerUseCase.execute(customer);
    }

    @PutMapping("/{id}")
    public Customer edit(@PathVariable String id, @RequestBody @Valid CustomerDto dto) throws CustomerNameNotAllowedException, CustomerIdNotFoundException, CustomerZipCodeNotFoundException {
        var customer = customerMapper.toDomain(dto);
        return editCustomerUseCase.execute(id, customer);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id) throws CustomerIdNotFoundException {
        return getByIdCustomerUseCase.execute(id);
    }

    @GetMapping
    public Page<Customer> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return listCustomerUseCase.execute(pageable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws CustomerIdNotFoundException {
        deleteCustomerUseCase.execute(id);
    }
}