package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.exception.Payment.PaymentAmountPaidNotAllowdException;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.CreatePaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.DeletePaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.EditPaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.GetByIdPaymentUseCase;
import com.example.FinancialSystem.core.useCase.PaymentUseCase.ListPaymentUseCase;
import com.example.FinancialSystem.entryPoint.controller.swagger.PaymentControllerApi;
import com.example.FinancialSystem.entryPoint.dto.PaymentDto;
import com.example.FinancialSystem.entryPoint.mapper.PaymentMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController implements PaymentControllerApi {

    private final PaymentMapper paymentMapper;
    private final CreatePaymentUseCase createPaymentUseCase;
    private final EditPaymentUseCase editCanceledPaymentUseCase;
    private final GetByIdPaymentUseCase getPaymentUseCase;
    private final DeletePaymentUseCase deletePaymentUseCase;
    private final ListPaymentUseCase listPaymentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Payment create(@RequestBody @Valid PaymentDto dto) throws PaymentMethodNotFoundException, PaymentAmountPaidNotAllowdException {
        var payment = paymentMapper.toDomain(dto);
        return createPaymentUseCase.execute(payment);
    }

    @PutMapping("/{id}")
    public Payment editStatusToCanceled(@PathVariable String id, @RequestBody @Valid PaymentDto dto) throws PaymentMethodNotFoundException, PaymentIdNotFoundException, PaymentAmountPaidNotAllowdException {
        var payment = paymentMapper.toDomain(dto);
        return editCanceledPaymentUseCase.execute(id, payment);
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable String id) throws PaymentIdNotFoundException {
        return getPaymentUseCase.execute(id);
    }

    @GetMapping
    public Page<Payment> findAll(@PageableDefault(size = 10)Pageable pageable) {
        return listPaymentUseCase.execute(pageable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws PaymentIdNotFoundException {
        deletePaymentUseCase.execute(id);
    }
}
