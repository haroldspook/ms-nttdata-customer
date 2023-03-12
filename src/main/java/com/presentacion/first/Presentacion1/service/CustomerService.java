package com.presentacion.first.Presentacion1.service;

import com.presentacion.first.Presentacion1.documents.Customer;

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
