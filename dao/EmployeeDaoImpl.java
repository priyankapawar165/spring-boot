package com.employee.dao;
import com.employee.dto.Employee;
import com.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class EmployeeDaoImpl implements EmployeeDao {
@Autowired
EmployeeRepository employeeRepository;
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }
}

