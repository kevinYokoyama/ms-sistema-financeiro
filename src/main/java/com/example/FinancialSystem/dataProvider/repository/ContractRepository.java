package com.example.FinancialSystem.dataProvider.repository;

import com.example.FinancialSystem.dataProvider.entity.ContractEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends MongoRepository<ContractEntity, String> {

}