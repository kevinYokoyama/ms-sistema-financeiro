package com.example.FinancialSystem.dataProvider.mapper;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    @Mapping(source = "entity.address.zipcode", target = "zipcode")
    Customer toDomain(CustomerEntity entity);

    CustomerEntity toEntity(Customer customer);
}
