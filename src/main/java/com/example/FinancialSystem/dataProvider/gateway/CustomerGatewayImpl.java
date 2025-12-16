package com.example.FinancialSystem.dataProvider.gateway;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerZipCodeNotFoundException;
import com.example.FinancialSystem.core.gateway.CustomerGateway;
import com.example.FinancialSystem.dataProvider.adapter.AddressAdapter;
import com.example.FinancialSystem.dataProvider.entity.CustomerEntity;
import com.example.FinancialSystem.dataProvider.mapper.CustomerEntityMapper;
import com.example.FinancialSystem.dataProvider.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;
    private final AddressAdapter addressAdapter;

    @Override
    public Customer save(Customer customer) throws CustomerZipCodeNotFoundException {

        var entity = customerEntityMapper.toEntity(customer);
        var addressEntity = customerAddress(customer);
        entity.setAddress(addressEntity);

        if (entity.getAddress().getBairro() == null) {
            log.error("Zip code not found");
            throw new CustomerZipCodeNotFoundException(customer.getZipcode());
        }


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

    private CustomerEntity.CustomerAddress customerAddress(Customer customer) {
        var addressResponse = addressAdapter.getAddress(customer.getZipcode());
        return CustomerEntity.CustomerAddress.builder()
                .zipcode(customer.getZipcode())
                .logradouro(addressResponse.logradouro())
                .complemento(addressResponse.complemento())
                .unidade(addressResponse.unidade())
                .bairro(addressResponse.bairro())
                .localidade(addressResponse.localidade())
                .uf(addressResponse.uf())
                .estado(addressResponse.estado())
                .build();
    }
}
