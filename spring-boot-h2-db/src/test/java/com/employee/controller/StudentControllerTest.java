package com.employee.controller;

import com.employee.dto.Student;
import com.employee.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    void testGetStudentList() throws Exception{
        List<Student> studList = new ArrayList<>();
        Student student = new Student();
        student.setFirstName("Chhaya");
        studList.add(student);

        when(studentService.getStudentList()).thenReturn(studList);

        mvc.perform(get("/student-list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Chhaya"));
    }
}
