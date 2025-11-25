package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Contract;

public interface ContractGateway {

    Contract save(Contract contract);

    void delete(String id);

    boolean existById(String id);

    Contract edit(Contract contract);

    Contract getById(String id);
}
