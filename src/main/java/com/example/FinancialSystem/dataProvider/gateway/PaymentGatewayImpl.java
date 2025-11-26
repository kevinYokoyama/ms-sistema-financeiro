package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import com.example.FinancialSystem.dataProvider.mapper.PaymentEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    @Override
    public Payment save(Payment payment) {

        var entity = paymentEntityMapper.toEntity(payment);
        var saved = paymentRepository.save(entity);

        return paymentEntityMapper.toDomain(saved);
    }

    @Override
    public void delete(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public boolean existById(String id) {
        return paymentRepository.existsById(id);
    }

    @Override
    public Payment getById(String id) {
        var entity = paymentRepository.findById(id).orElse(null);

        return paymentEntityMapper.toDomain(entity);
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }
}
