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

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingUser = employeeRepository.findById(employee.getId()).get();
        existingUser.setFirstName(employee.getFirstName());
        existingUser.setLastName(employee.getLastName());
        Employee updatedUser = employeeRepository.save(existingUser);
        return updatedUser;
    }


    public void deleteEmployee(int userId) {
       employeeRepository.deleteById(userId);
    }
}
