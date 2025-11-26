package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerGateway {

    Customer save(Customer customer);

    void delete(String id);

    boolean existById(String id);

    Customer getById(String id);

    Page<Customer> findAll(Pageable pageable);
}
