package com.campus.vuelosglobales.customer.application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campus.vuelosglobales.customer.domain.entities.Customer;
import com.campus.vuelosglobales.customer.domain.repositories.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
