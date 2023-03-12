package com.presentacion.first.Presentacion1.controller;


import com.presentacion.first.Presentacion1.documents.Customer;
import com.presentacion.first.Presentacion1.service.CustomerService;
import com.presentacion.first.Presentacion1.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Customer>>getCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<HttpStatus>deleteCustomer(){
        customerService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Customer>saveCustomer(@RequestBody Customer customer){
       /* Message message = {
            System.out.println("inciando la conexión para listar");
        };
        message
        if(customerService.findAll().get(0).getNumberDocument() !=customer.getNumberDocument()){
        }else{
            return new ResponseEntity<Customer>(, HttpStatus.OK);
        }
*/
        return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);

    }

}
