package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Customer;

public interface CustomerGateway {

    Customer save(Customer customer);

    void delete(String id);

    boolean existById(String id);

    Customer edit(Customer contract);

    Customer getById(String id);
}
