package com.example.FinancialSystem.dataProvider.repository;

import com.example.FinancialSystem.dataProvider.entity.ContractEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContractRepository extends MongoRepository<ContractEntity, String> {
    @Override
    List<ContractEntity> findAllById(Iterable<String> strings);
}
