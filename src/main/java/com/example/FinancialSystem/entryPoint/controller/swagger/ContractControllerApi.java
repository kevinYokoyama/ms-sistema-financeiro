package com.example.FinancialSystem.entryPoint.controller.swagger;

import com.example.FinancialSystem.core.domain.Contract;
import com.example.FinancialSystem.core.exception.Contract.ContractIdNotFoundException;
import com.example.FinancialSystem.core.exception.Contract.ContractOperationPeriodNotAllowed;
import com.example.FinancialSystem.core.exception.Contract.ContractRequestAmountNotAllowedException;
import com.example.FinancialSystem.entryPoint.dto.ContractDto;
import com.example.FinancialSystem.entryPoint.handler.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "ContractController", description = "Contract controller")
public interface ContractControllerApi {

    @Operation(summary = "Create a contract", description = "Create a contract with the customer id, operation period and requested amount")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Return the created contract", content = {@Content(schema = @Schema(implementation = Contract.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Contract create(ContractDto dto) throws ContractRequestAmountNotAllowedException, ContractOperationPeriodNotAllowed;

    @Operation(summary = "Edit a contract", description = "Update the id customer, requested amount and the operation period of the contract specified in the path by their id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a contract already edited", content = {@Content(schema = @Schema(implementation = Contract.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Contract edit(String id, ContractDto dto) throws ContractRequestAmountNotAllowedException, ContractIdNotFoundException;

    @Operation(summary = "Search a contract by their id", description = "Search for a contract by the id in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return the contract according to the id", content = {@Content(schema = @Schema(implementation = Contract.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Contract getById(String id) throws ContractIdNotFoundException;

    @Operation(summary = "Show contracts", description = "Show all contracts according to the size")
    Page<Contract> findAll(Pageable pageable);

    @Operation(summary = "Delete a contract", description = "Delete a contract by the id specified in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Don`t have a return because it returns void"),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    void delete(@PathVariable String id) throws ContractIdNotFoundException;
}
