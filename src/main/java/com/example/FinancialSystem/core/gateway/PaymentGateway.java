package com.example.FinancialSystem.core.gateway;

import com.example.FinancialSystem.core.domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentGateway {

    Payment save(Payment payment);

    void delete(String id);

    boolean existById(String id);

    Payment getById(String id);

    Page<Payment> findAll(Pageable pageable);
}
