package com.bankingapplication.CustomerManagementService.repositories;

import com.bankingapplication.CustomerManagementService.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerManagementRepository extends JpaRepository<CustomerEntity, Integer> {
}
