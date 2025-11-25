package com.example.FinancialSystem.dataProvider.mapper;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.dataProvider.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    Payment toDomain(PaymentEntity paymentEntity);

    PaymentEntity toEntity(Payment payment);
}
