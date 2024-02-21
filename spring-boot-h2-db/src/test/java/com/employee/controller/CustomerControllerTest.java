package com.employee.controller;

import com.employee.dto.Customer;
import com.employee.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.List;



@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void testGetCustomerList() throws Exception{

        List<Customer> customerList = new ArrayList<>() ;
        Customer customer = new Customer();
        customer.setFirstName("Jaya");
        customerList.add(customer);

        when(customerService.getCustomerList()).thenReturn(customerList);

        mvc.perform(get("/customer-list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Jaya"));
    }
}
