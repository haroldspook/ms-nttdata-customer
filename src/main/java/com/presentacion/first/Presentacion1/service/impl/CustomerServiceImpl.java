package com.presentacion.first.Presentacion1.service.impl;

import com.presentacion.first.Presentacion1.documents.Customer;
import com.presentacion.first.Presentacion1.repository.CustomerRepository;
import com.presentacion.first.Presentacion1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase que contiene la lógica del cliente respecto al CRUD
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /***
     * Este método listará todos los clientes
     * aplicando unas condicionales de solo los que tengan mayores
     * a 17 anios y que esten acitivos.
     * @return lista de clientes (Customer)
     */
    @Override
    public List<Customer> findAll() {
       return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getAge() > 17)
                .filter(customer -> customer.getStatus() == true)
                .collect(Collectors.toList());
    }

    /***
     * Este método listará los clientes con el mismo número de documento
     * @return Lista de clientes
    **/
    @Override
    public List<Customer> findAllById(Integer numberDocument) {
       return customerRepository.findAll()
               .stream()
               .filter(customer -> customer.getNumberDocument().equals(numberDocument))
               .collect(Collectors.toList());
    }

    /***
     * Este método listará los clientes con el mismo número de documento
     * @return Cliente (Customer)
     **/
    @Override
    public Customer save(Customer customer) {

       /* return customerRepository.save(customerRepository.findAll()
                .stream()
                .filter(customerL -> !customerL.getNumberDocument().equals(customer.getNumberDocument()))
                .collect(Collectors.toList()).get(0));*/
        return customerRepository.save(customer);

    }

    /***
     * Este método eliminará a los clientes
     **/
    @Override
    public void delete() {
        customerRepository.deleteAll();
    }
}
