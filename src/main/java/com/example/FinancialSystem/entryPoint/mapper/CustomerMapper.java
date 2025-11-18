package com.example.FinancialSystem.entryPoint.mapper;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.entryPoint.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toDomain(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);
}
