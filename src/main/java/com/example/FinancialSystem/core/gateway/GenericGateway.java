package com.example.FinancialSystem.core.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericGateway<E> {

    E save(E customer);

    void delete(String id);

    boolean existById(String id);

    E getById(String id);

    Page<E> findAll(Pageable pageable);
}
