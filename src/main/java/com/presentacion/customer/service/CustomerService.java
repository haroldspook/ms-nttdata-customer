package com.presentacion.customer.service;

import com.presentacion.customer.model.dto.request.CustomerRequest;
import com.presentacion.customer.model.dto.response.CustomerResponse;

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
