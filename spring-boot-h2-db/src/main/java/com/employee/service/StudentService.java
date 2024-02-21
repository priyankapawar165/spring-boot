package com.employee.service;

import com.employee.dto.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudentList();

    public Student addStudent(Student student);
    
}
