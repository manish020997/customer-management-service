package com.bankingapplication.CustomerManagementService.controller;

import com.bankingapplication.CustomerManagementService.entities.CustomerEntity;
import com.bankingapplication.CustomerManagementService.services.CustomerManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerManagementController {

    @Autowired
    CustomerManagementService customerManagementService;

    @PostMapping(path = "/customer")
    public ResponseEntity<CustomerEntity> createCustomerProfile(@RequestBody @Valid CustomerEntity customer) {

        CustomerEntity customerEntity = customerManagementService.createCustomerProfile(customer);

        return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all-customers")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {

        final List<CustomerEntity> customerEntityList = customerManagementService.getAllCustomers();

        return new ResponseEntity<>(customerEntityList, HttpStatus.OK);
    }

    @GetMapping(path = "get/customer/{id}")
    public ResponseEntity<CustomerEntity> fetchSingleCustomerBasedOnId(@PathVariable("id") int customerId) {

        CustomerEntity customer = customerManagementService.fetchSingleCustomerBasedOnId(customerId);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping(path = "update/customer/{id}")
    public ResponseEntity<CustomerEntity> updateSingleCustomerDetails(@RequestBody CustomerEntity customerEntity, @PathVariable int id) {

        CustomerEntity updatedCustomer = customerManagementService.updateSingleCustomerDetails(customerEntity, id);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/customer/{id}")
    public ResponseEntity<CustomerEntity> deleteSingleCustomer(@PathVariable("id") Integer customerId) {
        CustomerEntity deletedCustomer = customerManagementService.deleteSingleCustomer(customerId);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }

}
