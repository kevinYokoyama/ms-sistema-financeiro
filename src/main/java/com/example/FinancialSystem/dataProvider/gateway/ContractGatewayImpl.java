package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import com.example.FinancialSystem.dataProvider.entity.ContractEntity;
import com.example.FinancialSystem.dataProvider.mapper.ContractEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContractGatewayImpl implements ContractGateway {

    private final ContractRepository contractRepository;
    private final ContractEntityMapper contractEntityMapper;

    @Override
    public Contract save(Contract contract) {
        var entity = contractEntityMapper.toEntity(contract);
        var saved = contractRepository.save(entity);

        return contractEntityMapper.toDomain(saved);
    }


    @Override
    public void delete(String id) {
        contractRepository.deleteById(id);
    }

    @Override
    public boolean existById(String id) {
        return contractRepository.existsById(id);
    }

    @Override
    public Contract getById(String id) {
        var entity = contractRepository.findById(id).orElse(null);

        return contractEntityMapper.toDomain(entity);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        Page<ContractEntity> entities = contractRepository.findAll(pageable);
        List<Contract> contracts = entities.map(contractEntityMapper::toDomain).getContent();
        return new PageImpl<>(contracts, pageable, entities.getTotalPages());
    }
}
