package com.employee.controller;

import com.employee.dto.Employee;
import com.employee.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee-list")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @PostMapping("/employee-add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/employee-update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
         employeeService.deleteEmployee(id);
         return "Employee is deleted";
    }
}

