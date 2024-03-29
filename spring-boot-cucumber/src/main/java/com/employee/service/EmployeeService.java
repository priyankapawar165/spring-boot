package com.employee.service;

import com.employee.dto.Employee;

import java.util.List;

public interface EmployeeService {
    
    public List<Employee> getEmployeeList();
   
    public Employee addEmployee(Employee employee);

    public void deleteEmployee(int userId);

    public Employee updateEmployee(Employee employee);

}
