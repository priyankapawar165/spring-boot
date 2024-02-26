package com.employee.dao;

import com.employee.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    
    public List<Employee> getEmployeeList();
    
    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(int userId);

}
