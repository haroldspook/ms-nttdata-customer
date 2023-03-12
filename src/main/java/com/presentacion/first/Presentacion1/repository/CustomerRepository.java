package com.presentacion.first.Presentacion1.repository;

import com.presentacion.first.Presentacion1.documents.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {

}
