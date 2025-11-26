package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContractGateway {

    Contract save(Contract contract);

    void delete(String id);

    boolean existById(String id);

    Contract getById(String id);

    Page<Contract> findAll(Pageable pageable);
}
