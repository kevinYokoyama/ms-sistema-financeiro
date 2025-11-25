package com.example.FinancialSystem.dataProvider.mapper;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toDomain(CustomerEntity customerEntity);

    CustomerEntity toEntity(Customer customer);
}
