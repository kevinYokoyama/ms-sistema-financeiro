package com.example.FinancialSystem.dataProvider.repository;

import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}