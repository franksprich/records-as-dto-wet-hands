package edu.spring.records.service;

import edu.spring.records.model.dto.Customer;

import java.util.List;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomer(Long customerId);

}
