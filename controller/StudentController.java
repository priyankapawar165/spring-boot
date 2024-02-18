package com.employee.controller;

import com.employee.dto.Student;
import com.employee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student-list")
    public List<Student> getStudentList() {
     return studentService.getStudentList();
    }
}
