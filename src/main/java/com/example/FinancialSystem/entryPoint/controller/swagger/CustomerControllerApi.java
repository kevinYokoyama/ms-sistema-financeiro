package com.example.FinancialSystem.entryPoint.controller.swagger;

import com.example.FinancialSystem.core.domain.Customer;
import com.example.FinancialSystem.core.exception.Customer.CustomerBirthdateNotAllowed;
import com.example.FinancialSystem.core.exception.Customer.CustomerIdNotFoundException;
import com.example.FinancialSystem.core.exception.Customer.CustomerNameNotAllowedException;
import com.example.FinancialSystem.core.exception.Customer.CustomerZipCodeNotFoundException;
import com.example.FinancialSystem.entryPoint.dto.CustomerDto;
import com.example.FinancialSystem.entryPoint.handler.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Tag(name = "CustomerController", description = "Customer controller")
public interface CustomerControllerApi {

    @Operation(summary = "Create a customer", description = "Create a customer with the name, document and the birthdate")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Return the created customer", content = {@Content(schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Customer create(CustomerDto dto) throws CustomerBirthdateNotAllowed, CustomerZipCodeNotFoundException;

    @Operation(summary = "Edit a customer", description = "Update the name of the customer specified in the path by their id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a customer already edited", content = {@Content(schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Customer edit(String id, CustomerDto dto) throws CustomerNameNotAllowedException, CustomerIdNotFoundException, CustomerZipCodeNotFoundException;

    @Operation(summary = "Search a customer by their id", description = "Search for a customer by the id in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return the customer according to the id", content = {@Content(schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Customer getById(String id) throws CustomerIdNotFoundException;

    @Operation(summary = "Show customers", description = "Show all customers according to the size")
    Page<Customer> findAll(Pageable pageable);

    @Operation(summary = "Delete a customer", description = "Delete a customer by the id specified in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Don`t have a return because it returns void"),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    void delete(String id) throws CustomerIdNotFoundException;
}
