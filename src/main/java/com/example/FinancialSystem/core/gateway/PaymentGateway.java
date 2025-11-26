package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Payment;

import java.util.List;

public interface PaymentGateway {

    Payment save(Payment payment);

    void delete(String id);

    boolean existById(String id);

    Payment getById(String id);

    List<Payment> findAll();
}
