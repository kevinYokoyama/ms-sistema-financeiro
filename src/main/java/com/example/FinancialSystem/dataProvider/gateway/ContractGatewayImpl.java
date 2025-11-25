package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.gateway.ContractGateway;
import com.example.FinancialSystem.dataProvider.mapper.ContractEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
    public Contract edit(Contract contract) {
        var entity = contractEntityMapper.toEntity(contract);
        var edited = contractRepository.save(entity);

        return contractEntityMapper.toDomain(edited);
    }

    @Override
    public Contract getById(String id) {
        var got = contractRepository.findById(id).orElse(null);

        return contractEntityMapper.toDomain(got);
    }


}
