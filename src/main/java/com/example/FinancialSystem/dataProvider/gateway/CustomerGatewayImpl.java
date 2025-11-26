package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import com.example.FinancialSystem.dataProvider.mapper.CustomerEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer save(Customer customer) {

        var entity = customerEntityMapper.toEntity(customer);
        var saved = customerRepository.save(entity);

        return customerEntityMapper.toDomain(saved);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existById(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Customer getById(String id) {
        var entity = customerRepository.findById(id).orElse(null);

        return customerEntityMapper.toDomain(entity);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<CustomerEntity> entities = customerRepository.findAll(pageable);
        List<Customer> contracts = entities.map(customerEntityMapper::toDomain).getContent();
        return new PageImpl<>(contracts, pageable, entities.getTotalElements());
    }
}
