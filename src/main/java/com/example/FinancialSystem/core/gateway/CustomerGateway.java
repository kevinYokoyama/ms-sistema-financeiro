package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Customer;

import java.util.List;

public interface CustomerGateway {

    Customer save(Customer customer);

    void delete(String id);

    boolean existById(String id);

    Customer getById(String id);

    List<Customer> findAll();
}
