package com.employee.dao;

import com.employee.dto.Customer;
import com.employee.service.CustomerService;
import com.employee.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CustomerDaoImplTest {
    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();
    @Mock
    private CustomerDao customerDao;
    @Test
    public void testGetCustomerList() {
        Customer customer = new Customer();
        customer.setFirstName("Seeta");

        List<Customer> list = new ArrayList<>();
        list.add(customer);

        when(customerDao.getCustomerList()).thenReturn(list);
        List<Customer> customerList = customerService.getCustomerList();
        assertEquals("Seeta", customerList.get(0).getFirstName());
    }
}
