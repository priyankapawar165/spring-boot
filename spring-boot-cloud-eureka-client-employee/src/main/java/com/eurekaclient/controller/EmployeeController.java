package com.eurekaclient.controller;


import java.util.ArrayList;
import java.util.List;

import com.eurekaclient.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    static List<Employee> lst = new ArrayList<Employee>();

    static {
        Employee emp = new Employee();
        emp.setName("John");
        lst.add(emp);
        emp = new Employee();
        emp.setName("Johnq");
        lst.add(emp);
    }

    @RequestMapping(value = "/employee-list", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        System.out.println("GettingEmployeeList details for ");
        return lst;
    }
}
