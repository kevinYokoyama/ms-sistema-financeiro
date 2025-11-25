package com.example.FinancialSystem.dataProvider.mapper;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.dataProvider.entity.ContractEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractEntityMapper {

    Contract toDomain(ContractEntity contractEntity);

    ContractEntity toEntity(Contract contract);
}



