package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Contract;

import java.util.List;

public interface ContractGateway {

    Contract save(Contract contract);

    void delete(String id);

    boolean existById(String id);

    Contract getById(String id);

    List<Contract> findAll();
}
