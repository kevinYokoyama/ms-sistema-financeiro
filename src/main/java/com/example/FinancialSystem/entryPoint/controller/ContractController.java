package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.exception.Contract.ContractOperationPeriodNotAllowed;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.core.useCase.ContractUseCase.CreateContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.DeleteContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.EditContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.GetByIdContractUseCase;
import com.example.FinancialSystem.core.useCase.ContractUseCase.ListContactUseCase;
import com.example.FinancialSystem.entryPoint.dto.ContractDto;
import com.example.FinancialSystem.entryPoint.mapper.ContractMapper;
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
@RequestMapping("/v1/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractMapper contractMapper;
    private final CreateContractUseCase createContractUseCase;
    private final EditContractUseCase editContractUseCase;
    private final GetByIdContractUseCase getByIdContractUseCase;
    private final DeleteContractUseCase deleteContractUseCase;
    private final ListContactUseCase listContactUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contract create(@RequestBody @Valid ContractDto dto) throws ContractRequestAmountNotAllowedException, ContractOperationPeriodNotAllowed {
        var contract = contractMapper.toDomain(dto);
        return createContractUseCase.execute(contract);
    }

    @PutMapping("/{id}")
    public Contract edit(@PathVariable String id, @RequestBody @Valid ContractDto dto) throws ContractRequestAmountNotAllowedException, ContractIdNotFoundException {
        var contract = contractMapper.toDomain(dto);
        return editContractUseCase.execute(id, contract);
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable String id) throws ContractIdNotFoundException {
        return getByIdContractUseCase.execute(id);
    }

    @GetMapping
    public Page<Contract> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return listContactUseCase.execute(pageable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws ContractIdNotFoundException {
        deleteContractUseCase.execute(id);
    }
}