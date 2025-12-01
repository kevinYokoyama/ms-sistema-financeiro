package com.example.FinancialSystem.entryPoint.controller.swagger;

import com.example.FinancialSystem.core.domain.Payment;
import com.example.FinancialSystem.core.exception.Payment.PaymentAmountPaidNotAllowdException;
import com.example.FinancialSystem.core.exception.Payment.PaymentIdNotFoundException;
import com.example.FinancialSystem.core.exception.Payment.PaymentMethodNotFoundException;
import com.example.FinancialSystem.entryPoint.dto.PaymentDto;
import com.example.FinancialSystem.entryPoint.handler.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Tag(name = "PaymentController", description = "Payment controller")
public interface PaymentControllerApi {

    @Operation(summary = "Create a payment", description = "Create a payment with the amount paid, payment method and the installment id")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Return the created payment", content = {@Content(schema = @Schema(implementation = Payment.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Payment create(PaymentDto dto) throws PaymentMethodNotFoundException, PaymentAmountPaidNotAllowdException;

    @Operation(summary = "Edit a payment", description = "Update the payment method")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a payment already edited", content = {@Content(schema = @Schema(implementation = Payment.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Payment editStatusToCanceled(String id, PaymentDto dto) throws PaymentMethodNotFoundException, PaymentIdNotFoundException, PaymentAmountPaidNotAllowdException;

    @Operation(summary = "Search a payment by their id", description = "Search for a payment by the id in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return the payment according to the id", content = {@Content(schema = @Schema(implementation = Payment.class))}),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    Payment get(String id) throws PaymentIdNotFoundException;

    @Operation(summary = "Show payments", description = "Show all payments according to the size")
    Page<Payment> findAll(Pageable pageable);

    @Operation(summary = "Delete a payment", description = "Delete a payment by the id specified in the path")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Don`t have a return because it returns void"),
            @ApiResponse(responseCode = "400", description = "Return a message error showing what is wrong", content = {@Content(schema =  @Schema(implementation = ApiError.class))})
    })
    void delete(String id) throws PaymentIdNotFoundException;
}

