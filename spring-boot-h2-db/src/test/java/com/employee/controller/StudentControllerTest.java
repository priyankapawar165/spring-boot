package com.employee.controller;

import com.employee.dto.Student;
import com.employee.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    void testGetStudentList() throws Exception {
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

    @Test
    void testAddStudentList() throws Exception {

        Student student = new Student();
        student.setFirstName("Maya");

        student.setId(11);

        when(studentService.addStudent(student)).thenReturn(student);

        mvc.perform(post("/student-add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                        .andExpect(status().isOk())
                        .andDo(print())
                .andExpect(jsonPath("$.firstName").value("Chhaya"));

    }
}
