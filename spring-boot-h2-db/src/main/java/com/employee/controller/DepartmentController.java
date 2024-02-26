package com.employee.controller;

import com.employee.dto.Department;
import com.employee.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept-list")
    public List<Department> getDepartmentList(){
        return departmentService.getDepartmentList();
    }

    @PostMapping("/department-add")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

}
