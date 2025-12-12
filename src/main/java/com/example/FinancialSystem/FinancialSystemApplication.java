package com.example.FinancialSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FinancialSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialSystemApplication.class, args);
	}

}
