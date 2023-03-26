package com.presentacion.customer.service;

import com.presentacion.customer.dto.request.CustomerRequest;
import com.presentacion.customer.dto.response.CustomerResponse;
import com.presentacion.customer.entity.Customer;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface CustomerService {
    Observable<CustomerResponse> findAll();
    Observable<CustomerResponse> findAllByNumberDocument(Integer numberDocument);
    Single<CustomerResponse> save(CustomerRequest request);
    Completable delete();
}
