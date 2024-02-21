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
    List<Customer> students = customerService.getCustomerList();

    assertEquals("Sam", students.get(0).getFirstName());
    
  }
  
}
