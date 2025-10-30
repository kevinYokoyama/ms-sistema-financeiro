package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentMethod;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        System.out.print("\nCreating a payment...");
        return Payment.builder()
                .id(payment.getId())
                .amountPaid(payment.getAmountPaid())
                .datePayment(LocalDate.now())
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .status(PaymentStatus.EXECUTED)
                .build();
    }

    @PutMapping
    public Payment edit(@RequestBody PaymentStatus status) {
        System.out.printf("\nEditing the status to %s", status);
        return null;
    }

    @GetMapping("/{id}")
    public List<Payment> get(@PathVariable String id) {
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public List<Payment> delete(@PathVariable String id) {
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
