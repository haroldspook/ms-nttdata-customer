package com.presentacion.customer.model.dto.request;

import com.google.gson.Gson;
import com.presentacion.customer.model.dto.request.CustomerRequest;
import com.presentacion.customer.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class CustomerRequestTest {
    private static final Gson GSON = new Gson();
    @Test
    @DisplayName("Cuando se guardan correctamente los datos del Cliente")
    public void returnSuccessWhenRequestIsNotNull() {
        CustomerRequest customerRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/customer_request.json"),
                CustomerRequest.class);

        var actual = customerRequest;
        assertThat(actual.getId()).isEqualTo(1);
        assertThat(actual.getStatus()).isNotNull();
        assertThat(actual.getTypeCustomer()).isNotNull();
        assertThat(actual.getTypeDocument()).isNotNull();
        assertThat(actual.getCreateAt()).isNotNull();
        assertThat(actual.getAge()).isNotNull();
        assertThat(actual.getLast()).isNotNull();
        assertThat(actual.getName()).isNotNull();
        assertThat(actual.getNumberDocument()).isNotNull();
    }

}