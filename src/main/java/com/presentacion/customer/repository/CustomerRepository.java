package com.presentacion.customer.repository;

import com.presentacion.customer.model.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Long> {

}
