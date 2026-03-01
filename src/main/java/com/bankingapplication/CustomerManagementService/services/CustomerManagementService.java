package com.bankingapplication.CustomerManagementService.services;

import com.bankingapplication.CustomerManagementService.entities.CustomerEntity;

import java.util.List;

public interface CustomerManagementService {

    CustomerEntity createCustomerProfile(CustomerEntity customerEntity);

    List<CustomerEntity> getAllCustomers();

    CustomerEntity fetchSingleCustomerBasedOnId(Integer customerId);

    CustomerEntity updateSingleCustomerDetails(CustomerEntity customerEntity, Integer customerId);

    CustomerEntity deleteSingleCustomer(Integer customerId);
}
