package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.CreatePaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.DeletePaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.EditCanceledPaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.GetPaymentUseCase;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final CreatePaymentUseCase createPaymentUseCase;
    private final EditCanceledPaymentUseCase editCanceledPaymentUseCase;
    private final GetPaymentUseCase getPaymentUseCase;
    private final DeletePaymentUseCase deletePaymentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return createPaymentUseCase.execute(payment);
    }

    @PutMapping
    public Payment editStatus(@RequestBody PaymentStatus status) {
        return editCanceledPaymentUseCase.execute(status);
    }

    @GetMapping("/{id}")
    public List<Payment> get(@PathVariable String id) {
        return getPaymentUseCase.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public List<Payment> delete(@PathVariable String id) {
        return deletePaymentUseCase.execute(id);
    }
}
