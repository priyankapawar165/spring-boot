package com.employee.service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(employeeDao.getEmployeeList()).thenReturn(Arrays.asList(employee));
        List<Employee> employees = employeeService.getEmployeeList();
        assertEquals("Tom", employees.get(0).getFirstName());
    }
}