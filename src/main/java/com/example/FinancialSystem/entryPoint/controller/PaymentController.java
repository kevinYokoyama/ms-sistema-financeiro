package com.example.FinancialSystem.entryPoint.controller;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.domain.enumeration.PaymentStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    @PostMapping
    public Payment post(){
        System.out.print("\nCreating a payment...");
        return null;
    }

    @PutMapping("/{status}")
    public Payment put(@PathVariable PaymentStatus status){
        System.out.printf("\nEditing the status to %s", status);
        return null;
    }

    @GetMapping("/{id}")
    public List<Payment> get(@PathVariable String id){
        System.out.printf("\nSearching for the id: %s", id);
        return List.of();
    }

    @DeleteMapping("/{id}")
    public List<Payment> delete(@PathVariable String id){
        System.out.printf("\nDeleting the id %s", id);
        return List.of();
    }
}
