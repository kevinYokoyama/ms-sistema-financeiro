package com.example.FinancialSystem.entryPoint.mapper;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.entryPoint.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "installmentId", target = "installment.id")
    Payment toDomain(PaymentDto dto);

    @Mapping(source = "installment.id", target = "installmentId")
    PaymentDto toDto(Payment payment);
}
