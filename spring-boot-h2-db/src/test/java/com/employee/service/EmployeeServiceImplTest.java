package com.employee.service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();
    
    @Mock
    private EmployeeDao employeeDao;

    @Test
    public void testGetEmployeeList() {

        Employee employee = new Employee();
        employee.setFirstName("Tom");
        
        List<Employee> list = new ArrayList<>();
        list.add(employee);

        when(employeeDao.getEmployeeList()).thenReturn(list);
       
        List<Employee> employees = employeeService.getEmployeeList();

        assertEquals("Tom", employees.get(0).getFirstName());
    }
    @Test
    public void testAddEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("Jaya");
        employee.setLastName("Bachhan");
        employee.setEmailAddress("J@B");
        employee.setPhoneNumber("12345");
        employee.setAddress("Lala Road");
        employee.setId(1);
        when(employeeDao.addEmployee(any())).thenReturn(employee);

        Employee employees = employeeService.addEmployee(employee);
        assertEquals("Jaya", employees.getFirstName());
        assertEquals("Bachhan", employees.getLastName());
        assertEquals("J@B", employees.getEmailAddress());
        assertEquals("12345", employees.getPhoneNumber());
        assertEquals("Lala Road", employees.getAddress());
        assertEquals(1, employees.getId());
    }
}