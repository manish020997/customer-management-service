package com.bankingapplication.CustomerManagementService.serviceimpls;

import com.bankingapplication.CustomerManagementService.entities.CustomerEntity;
import com.bankingapplication.CustomerManagementService.exceptionhandling.CustomerNotFoundException;
import com.bankingapplication.CustomerManagementService.repositories.CustomerManagementRepository;
import com.bankingapplication.CustomerManagementService.services.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {

    @Autowired
    CustomerManagementRepository repo;

    @Override
    public CustomerEntity createCustomerProfile(CustomerEntity customerEntity) {

        try {
            return repo.save(customerEntity);
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }
        return customerEntity;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {

        List<CustomerEntity> customerEntityList = repo.findAll();

        if (customerEntityList.isEmpty()) {
            throw new CustomerNotFoundException("No data for customers is found in the system.", HttpStatus.NOT_FOUND);
        }

        return customerEntityList;
    }

    @Override
    public CustomerEntity fetchSingleCustomerBasedOnId(Integer customerId) {

        Optional<CustomerEntity> customer = repo.findById(customerId);
        customer.orElseThrow(() -> new CustomerNotFoundException("Customer not present in the system with id: " + customerId, HttpStatus.NOT_FOUND));
        return customer.get();
    }

    @Override
    public CustomerEntity updateSingleCustomerDetails(CustomerEntity customerEntity, Integer customerId) {

        CustomerEntity customerEntityDB = fetchSingleCustomerBasedOnId(customerId);
        if (customerEntityDB != null || Objects.equals(customerEntity.getId(), customerId)) {
            customerEntity.setId(customerId);
            return repo.save(customerEntity);
        }// else throw exception CustomerNotFound
        else {
            throw new CustomerNotFoundException("Customer not present in the system with id: " + customerId, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public CustomerEntity deleteSingleCustomer(Integer customerId) {
        CustomerEntity customerEntityDB = fetchSingleCustomerBasedOnId(customerId);
        if (customerEntityDB != null) {
            repo.delete(customerEntityDB);
            System.out.println("User Deleted : " + customerId);
        }// else throw exception CustomerNotFound
        else {
            throw new CustomerNotFoundException("Customer not present in the system with id: " + customerId, HttpStatus.NOT_FOUND);
        }
        return null;
    }

}
