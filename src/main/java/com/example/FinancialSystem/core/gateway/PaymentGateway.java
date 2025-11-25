package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Payment;

public interface PaymentGateway {

    Payment save(Payment payment);

    void delete(String id);

    boolean existById(String id);

    Payment edit(Payment contract);

    Payment getById(String id);
}
