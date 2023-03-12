package com.presentacion.first.Presentacion1.service;

import com.presentacion.first.Presentacion1.documents.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    List<Customer> findAllById(String id);
    Customer save(Customer customer);
    void delete();
}
