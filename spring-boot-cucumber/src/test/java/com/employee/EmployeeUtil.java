package com.employee;

import com.employee.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class EmployeeUtil {
    public static String URL = "http://localhost:8080";

    public static Employee getEmployee() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("employee.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}