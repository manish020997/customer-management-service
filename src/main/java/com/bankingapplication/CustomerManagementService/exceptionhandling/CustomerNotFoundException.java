package com.bankingapplication.CustomerManagementService.exceptionhandling;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerNotFoundException extends RuntimeException {

    @Serial
    @Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 11L;

    private String errorMessage;

    private HttpStatus errorCode;
}
