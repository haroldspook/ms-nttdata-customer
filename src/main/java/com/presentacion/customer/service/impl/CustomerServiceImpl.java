package com.presentacion.customer.service.impl;

import com.presentacion.customer.model.dto.request.CustomerRequest;
import com.presentacion.customer.model.dto.response.CustomerResponse;
import com.presentacion.customer.repository.CustomerRepository;
import com.presentacion.customer.service.CustomerService;
import com.presentacion.customer.util.CustomerBuilder;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;

/**
 * Clase que contiene la lógica del cliente respecto al CRUD
 */
@Service
@Slf4j
@AllArgsConstructor
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
    public Observable<CustomerResponse> findAll() {
        log.info("Obtener todos los registros de Productos");
       return Observable.fromIterable(customerRepository.findAll())
               .map(customer -> CustomerBuilder.customerEntityToCustomerResponse(customer))
               .filter(customerResponse -> customerResponse.getAge() > 17
                       && customerResponse.getStatus().equals(true))
               .subscribeOn(Schedulers.io());
    }

    /***
     * Este método listará los clientes con el mismo número de documento
     * @return Lista de clientes
    **/
    @Override
    public Observable<CustomerResponse> findAllByNumberDocument(Integer numberDocument) {
        log.info("Obtener todos los registros de Productos acorde al numero de documento");
       return findAll()
               .filter(customerResponse -> customerResponse.getNumberDocument().equals(numberDocument))
               .subscribeOn(Schedulers.io());
    }

    /***
     * Este método se guardara la informacion del cliente
     * @return Cliente (Customer)
     **/
    @Override
    public Single<CustomerResponse> save(CustomerRequest request) {
        log.info("Se guardan los parametros enviados");
        return Single.just(customerRepository.save(CustomerBuilder.customerRequestToCustomerEntity(request)))
                .map(customer -> CustomerBuilder.customerEntityToCustomerResponse(customer));
    }

    /***
     * Este método eliminará a los clientes
     **/
    @Override
    public Completable delete() {
        log.info("Se eliminan todos los registros");
        customerRepository.deleteAll();
        return Completable.complete();
    }
}
