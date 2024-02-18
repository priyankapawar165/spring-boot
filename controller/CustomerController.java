package com.employee.controller;

import com.employee.dto.Customer;
import com.employee.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer-list")

    public List<Customer> getCustomerList(){
       return customerService.getCustomerList();
    }
   

}


