package edu.spring.records.service.impl;

import edu.spring.records.mapper.CustomerMapper;
import edu.spring.records.model.dto.Customer;
import edu.spring.records.model.entity.CustomerEntity;
import edu.spring.records.repo.CustomerRepo;
import edu.spring.records.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;


    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll()
                .stream()
                .map(customerMapper::toDto).toList();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return null;
    }
}
