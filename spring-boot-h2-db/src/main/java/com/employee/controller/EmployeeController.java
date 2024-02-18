package com.employee.controller;

import com.employee.dto.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee-list")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    
    }
}
