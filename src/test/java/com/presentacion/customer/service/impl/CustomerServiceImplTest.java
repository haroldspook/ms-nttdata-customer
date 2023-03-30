package com.presentacion.customer.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.customer.model.dto.request.CustomerRequest;
import com.presentacion.customer.model.dto.response.CustomerResponse;
import com.presentacion.customer.model.entity.Customer;
import com.presentacion.customer.repository.CustomerRepository;
import com.presentacion.customer.util.TestUtil;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    private static final Gson GSON = new Gson();
    private static final Integer DOCUMENT_NUMBER = Integer.valueOf(77777777);


    @BeforeEach
    void setUp() {
        initMocks(this);
        this.customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Clientes")
    public void returnListCustomerResponseWhenGetCustomerIsOk() {
        Customer customer = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
                Customer.class);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        when(customerRepository.findAll()).thenReturn(customerList);
        TestObserver<CustomerResponse> testObserver = customerService.findAll().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Obtiene todos  los datos de los Clientes acorde al numero de documento")
    public void returnListCustomerResponseWhenfindAllByNumberDocument() {
        Customer customer = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
                Customer.class);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        when(customerRepository.findAll()).thenReturn(customerList);
        TestObserver<CustomerResponse> testObserver = customerService.findAllByNumberDocument(DOCUMENT_NUMBER).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Cuando se guardan correctamente los datos del Cliente")
    public void returnSuccessWhenSaveOk(){

    Customer customer = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
            Customer.class);
    CustomerRequest customerRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_response.json"),
            CustomerRequest.class);
    when(customerRepository.save(any())).thenReturn(customer);

    TestObserver<CustomerResponse> testObserver = customerService.save(customerRequest).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    @Test
    @DisplayName("Elimina toda la lista de Clientes")
    public void returnOkWhenDeleteListCustomer(){
        TestObserver<Void> testObserver = customerService.delete().test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }
}