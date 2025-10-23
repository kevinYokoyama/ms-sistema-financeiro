package com.example.FinancialSystem.dataProvider.repository;

import com.example.FinancialSystem.dataProvider.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository <PaymentEntity, String> {
    @Override
    List<PaymentEntity> findAllById(Iterable<String> strings);

    @Override
    List<PaymentEntity> findAll();

}
