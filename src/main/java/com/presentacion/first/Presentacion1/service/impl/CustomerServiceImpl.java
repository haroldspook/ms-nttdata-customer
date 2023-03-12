package com.presentacion.first.Presentacion1.service.impl;

import com.presentacion.first.Presentacion1.documents.Customer;
import com.presentacion.first.Presentacion1.repository.CustomerRepository;
import com.presentacion.first.Presentacion1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
       return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getAge() > 17)
                .filter(customer -> customer.getStatus() == true)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllById(String id) {
       // return customerRepository.findAllById(id);
       return null;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete() {
        customerRepository.deleteAll();
    }
}
