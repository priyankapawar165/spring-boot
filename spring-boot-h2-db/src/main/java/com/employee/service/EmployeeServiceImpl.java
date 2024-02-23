package com.employee.service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getEmployeeList() {
        return employeeDao.getEmployeeList();
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }


    public void deleteEmployee(int id) {
         employeeDao.deleteEmployee(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

}
