package com.bankingapplication.CustomerManagementService.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Positive
    @Digits(integer = 120, fraction = 0, message = "Age should not exceed 120.")
    private Integer age;

    @NotBlank(message = "Address should not be blank.")
    @Size(min = 1, max = 100, message = "Address should not exceed more than 100 characters.")
    private String address;

    @NotBlank(message = "Email ID should not be blank.")
    @Email(message = "Email ID is not valid.", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String emailId;

    @NotBlank(message = "Phone Number should not be blank.")
    private String phoneNumber;


}
