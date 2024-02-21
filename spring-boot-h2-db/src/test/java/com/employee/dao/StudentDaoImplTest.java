package com.employee.dao;

import com.employee.dto.Student;

import com.employee.service.StudentService;
import com.employee.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentDaoImplTest {

    @InjectMocks
    private StudentService studentService = new StudentServiceImpl();


    @Mock
    private StudentDao studentDao;

    @Test
    public void getStudentList(){
        Student student = new Student();
        student.setFirstName("Sam");

        List<Student> list = new ArrayList<>();
        list.add(student);

        when(studentDao.getStudentList()).thenReturn(list);
        List<Student> students = studentService.getStudentList();
        assertEquals("Sam", students.get(0).getFirstName());
    }


}
