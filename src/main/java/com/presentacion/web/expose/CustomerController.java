package com.presentacion.web.expose;


import com.presentacion.customer.model.dto.request.CustomerRequest;
import com.presentacion.customer.model.dto.response.CustomerResponse;
import com.presentacion.customer.service.CustomerService;
import com.presentacion.customer.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.reactivex.Observable;

/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "MICROSERVICIO CUSTOMER", description = "Microservicio desarrollado para Administrar los Clientes")
@Slf4j
public class CustomerController {

    /**
     * Inyectamos la clase CustomerServiceImpl
     */
    @Autowired
    private CustomerService customerService;

    /**
     * Método que listará los clientes (Customer)
     * @return Lista de clientes Customer
     */
    @GetMapping
    @ApiOperation(value = Constants.GET_ALL_VALUE, notes = Constants.GET_ALL_NOTE)
    public Observable<CustomerResponse> getAllCustomer(){
        log.info("Obtencion de datos ");
        return customerService.findAll();
    }

    /**
     * Metodo que eliminará todos los clientes (Customer)
     */
    @DeleteMapping
    @ApiOperation(value = Constants.DELETE_VALUE, notes = Constants.DELETE_NOTE)
    public Completable deleteListCustomer(){
        log.info("Eliminar todos los datos");
        return customerService.delete();
    }

    /**
     * Método que registrará los clientes
     * @param request
     * @return El mismo cliente para ver su inserción
     */
    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Single<CustomerResponse> saveCustomer(@RequestBody CustomerRequest request){
        log.info("Envio de parametros");
        return customerService.save(request);
    }

}
