package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.domain.enumeration.ContractStatus;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/v1/contracts")
public class ContractController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contract create(@RequestBody Contract data) {
        System.out.print("\nCreating a contract...");
        return Contract.builder()
                .id(data.getId())
                .requestAmount(data.getRequestAmount())
                .startDate(LocalDate.now())
                .status(ContractStatus.ACTIVE)
                .build();
    }

    @PutMapping
    public Contract edit(@RequestBody Contract contract) {
        var contract2 = Contract.builder()
                .id("1")
                .status(ContractStatus.ACTIVE)
                .daysOverdue(10)
                .build();
        System.out.printf("\nEditing the days overdue to %d", contract.getDaysOverdue());
        return contract2;
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable String id) {
        var contract1 = Contract.builder()
                .id("1")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(1000))
                .startDate(LocalDate.now())
                .build();
        var contract2 = Contract.builder()
                .id("2")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(2000))
                .startDate(LocalDate.now())
                .build();
        var contract3 = Contract.builder()
                .id("3")
                .status(ContractStatus.ACTIVE)
                .requestAmount(BigDecimal.valueOf(3000))
                .startDate(LocalDate.now())
                .build();

        if (contract1.getId().equals(id)) {
            return contract1;
        }
        else if (contract2.getId().equals(id)) {
            return contract2;
        }
        else if (contract3.getId().equals(id)) {
            return contract3;
        }
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public List<Contract> delete(@PathVariable String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}