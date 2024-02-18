package com.employee.dao;

import com.employee.dto.Employee;
import com.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeDaoImplTest {
    @InjectMocks
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Mock
    private EmployeeRepository repository;
    @Test
    public void testGetEmployeeList() {
        Employee employee = new Employee();
        employee.setFirstName("Tom");
        when(repository.findAll()).thenReturn(List.of(employee));
        List<Employee> employees = employeeDao.getEmployeeList();
        assertEquals("Tom", employees.get(0).getFirstName());
    }
}