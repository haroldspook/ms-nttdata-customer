package com.presentacion.customer.service;

import com.presentacion.customer.documents.Customer;

import java.util.List;

/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface CustomerService {
    List<Customer> findAll();
    List<Customer> findAllById(Integer numberDocument);
    Customer save(Customer customer);
    void delete();
}
