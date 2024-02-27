package com.eurekaclient.controller;

import com.eurekaclient.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/customer-list", method = RequestMethod.GET)
    public List<Employee> getCustomer() {
        Employee[] itemsArray = restTemplate.getForObject("http://employee-service/employee-list", Employee[].class);
        return Arrays.asList(itemsArray);
    }


}