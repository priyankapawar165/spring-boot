package com.employee.service;

import com.employee.dao.CustomerDao;
import com.employee.dto.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

  @InjectMocks
  private CustomerService customerService = new CustomerServiceImpl() ;
    
  @Mock
  private CustomerDao customerDao;

  @Test
  public void testGetStudentList(){
    Customer customer = new Customer();
    customer .setFirstName("Sam");

    List<Customer> list = new ArrayList<>();
    list.add(customer );

    when(customerDao.getCustomerList()).thenReturn(list);
    List<Customer> customers = customerService.getCustomerList();

    assertEquals("Sam", customers.get(0).getFirstName());
    
  }
  @Test
  public void testAddCustomer(){
    Customer customer = new Customer();
    customer.setId(7);
    customer.setFirstName("Raha");
    customer.setLastname("Ching");
    customer.setAddress("Ram Road");
    customer.setPhoneNumber("1234");

    when(customerDao.addCustomer(customer)).thenReturn(customer);

    Customer customers = customerService.addCustomer(customer);
    assertEquals(7, customers.getId());
    assertEquals("Raha", customers.getFirstName());
    assertEquals("Ching", customers.getLastName());
    assertEquals("Ram Road", customers.getAddress());
    assertEquals("1234", customers.getPhoneNumber());
    }

  }
  

