package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.gateway.PaymentGateway;
import com.example.FinancialSystem.dataProvider.entity.PaymentEntity;
import com.example.FinancialSystem.dataProvider.mapper.PaymentEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<Payment> findAll(Pageable pageable) {
        Page<PaymentEntity> entities = paymentRepository.findAll(pageable);
        List<Payment> contracts = entities.map(paymentEntityMapper::toDomain).getContent();
        return new PageImpl<>(contracts, pageable, entities.getTotalPages());
    }
}
