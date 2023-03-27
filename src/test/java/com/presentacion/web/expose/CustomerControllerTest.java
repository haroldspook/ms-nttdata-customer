package com.presentacion.web.expose;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.presentacion.customer.dto.request.CustomerRequest;
import com.presentacion.customer.dto.response.CustomerResponse;
import com.presentacion.customer.service.CustomerService;

import com.google.gson.Gson;
import com.presentacion.customer.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private static final Gson GSON = new Gson();

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Clientes")
    void returnListCustomerResponseWhenGetCustomerIsOk() {
        CustomerResponse customerResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
                CustomerResponse.class);
        when(customerService.findAll()).thenReturn(Observable.just(customerResponse));
        TestObserver<CustomerResponse> testObserver = customerController.getAllCustomer().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Elimina toda la lista de Clientes")
    public void returnOkWhenDeleteListCustomer() {
        when(customerService.delete()).thenReturn(Completable.complete());
        TestObserver<Void> testObserver = customerController.deleteListCustomer().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Cuando se guardan correctamente los datos del Cliente")
    public void returnSuccessWhenSaveOk() {
        CustomerRequest customerRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_request.json"),
                CustomerRequest.class);
        CustomerResponse customerResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
                CustomerResponse.class);
        when(customerService.save(any())).thenReturn(Single.just(customerResponse));
        TestObserver<CustomerResponse> testObserver = customerController.saveCustomer(customerRequest).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }
}