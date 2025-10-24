package com.example.FinancialSystem.dataProvider.repository;

import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    @Override
    List<CustomerEntity> findAllById(Iterable<String> strings);
}
