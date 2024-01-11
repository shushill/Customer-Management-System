package sushil.test.service;

import sushil.test.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    List<Customer> createMultipleCustomer(List<Customer> customers);

    List<Customer> updateMultipleCustomer(List<Customer> customers);

    List<Customer> getAllCustomer();

    Customer getCustomerById(long Id);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomerById(Long id);
}
