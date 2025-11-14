package com.example.FinancialSystem.entryPoint.mapper;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.entryPoint.dto.ContractDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    @Mapping(source = "customerId", target = "customer.id")
    Contract toDomain(ContractDto dto);

    @Mapping(source = "customer.id", target = "customerId")
    ContractDto toDto(Contract contract);

}
