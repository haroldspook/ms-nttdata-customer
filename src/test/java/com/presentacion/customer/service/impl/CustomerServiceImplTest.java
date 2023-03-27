package com.presentacion.customer.service.impl;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.gson.Gson;
import com.presentacion.customer.dto.request.CustomerRequest;
import com.presentacion.customer.dto.response.CustomerResponse;
import com.presentacion.customer.entity.Customer;
import com.presentacion.customer.repository.CustomerRepository;
import com.presentacion.customer.util.CustomerBuilder;
import com.presentacion.customer.util.TestUtil;
import io.reactivex.Observable;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerBuilder customerBuilder;

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
    public void returnSuccessWhenSaveOk() {
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