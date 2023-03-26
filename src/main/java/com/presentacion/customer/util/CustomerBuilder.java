package com.presentacion.customer.util;

import com.presentacion.customer.dto.request.CustomerRequest;
import com.presentacion.customer.dto.response.CustomerResponse;
import com.presentacion.customer.entity.Customer;

public class CustomerBuilder {
    public final static Customer customerRequestToCustomerEntity (CustomerRequest request){
        return Customer.builder()
                .id(request.getId())
                .name(request.getName())
                .last(request.getLast())
                .age(request.getAge())
                .status(request.getStatus())
                .typeDocument(request.getTypeDocument())
                .numberDocument(request.getNumberDocument())
                .typeCustomer(request.getTypeCustomer())
                .build();
    }

    public static CustomerResponse customerEntityToCustomerResponse(Customer model){
        return CustomerResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .last(model.getLast())
                .age(model.getAge())
                .status(model.getStatus())
                .typeDocument(model.getTypeDocument())
                .numberDocument(model.getNumberDocument())
                .typeCustomer(model.getTypeCustomer())
                .build();
    }
}
