package com.presentacion.first.Presentacion1.controller;


import com.presentacion.first.Presentacion1.documents.Customer;
import com.presentacion.first.Presentacion1.service.CustomerService;
import com.presentacion.first.Presentacion1.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    /**
     * Inyectamos la clase CustomerServiceImpl
     */
    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * Método que listará los clientes (Customer)
     * @return Lista de clientes Customer
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Customer>>getCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que eliminará todos los clientes (Customer)
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<HttpStatus>deleteListCustomer(){
        customerService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que registrará los clientes
     * @param customer
     * @return El mismo cliente para ver su inserción
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Customer>saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);

    }

}
