package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.useCase.ContractUseCase.CreateContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.DeleteContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.EditContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.GetByIdContractUseCase;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/v1/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final CreateContractUseCase createContractUseCase;
    private final EditContractUseCase editContractUseCase;
    private final GetByIdContractUseCase getByIdContractUseCase;
    private final DeleteContractUseCase deleteContractUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contract create(@RequestBody Contract data) {
        return createContractUseCase.execute(data.getId(), data.getRequestAmount());
    }

    @PutMapping
    public Contract edit(@RequestBody Contract contract) {
        return editContractUseCase.execute(contract);
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable String id) {
        return getByIdContractUseCase.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Contract delete(@PathVariable String id) {
        return deleteContractUseCase.execute(id);
    }
}