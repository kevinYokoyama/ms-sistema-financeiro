package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Contract;
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
@RequestMapping("/v1/contracts")
public class ContractController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contract create() {
        System.out.print("\nCreating a contract...");
        return null;
    }

    @PutMapping("/{daysOverdue}")
    public Contract edit(@PathVariable Integer daysOverdue) {
        System.out.printf("\nEditing the days overdue to %d", daysOverdue);
        return null;
    }

    @GetMapping("/{id}")
    public List<Contract> get(@PathVariable String id) {
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public List<Contract> delete(@PathVariable String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
