package com.employee.dao;

import com.employee.dto.Customer;
import com.employee.repository.CustomerRepository;
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
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Mock
    private CustomerRepository customerRepository;
    @Test
    public void testGetCustomerList() {
        Customer customer = new Customer();
        customer.setFirstName("Seeta");

        List<Customer> list = new ArrayList<>();
        list.add(customer);

        when(customerRepository.findAll()).thenReturn(list);
        List<Customer> customerList = customerRepository.findAll();
        assertEquals("Seeta", customerList.get(0).getFirstName());
    }
    @Test
    public void testAddCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Lara");
        customer.setId(1);
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer actualCustomer = customerDao.addCustomer(customer);
        assertEquals("Lara", actualCustomer.getFirstName());
        assertEquals(1, actualCustomer.getId());
    }
}
