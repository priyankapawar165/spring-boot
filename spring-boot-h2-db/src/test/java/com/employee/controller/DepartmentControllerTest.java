package com.employee.controller;

import com.employee.dto.Department;
import com.employee.service.DepartmentService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EmployeeController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    void testGetDepartmentList() throws Exception {

        List<Department> departmentList = new ArrayList<>();
        Department department = new Department();
        department.setDeptName("IT");
        departmentList.add(department);

        when(departmentService.getDepartmentList()).thenReturn(departmentList);

        mvc.perform(get("/department-list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("IT"));

    }
    }


