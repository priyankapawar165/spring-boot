package com.employee.controller;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.employee.dto.Employee;
import com.employee.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;
  
  @MockBean
  private EmployeeService service;

  @Test
  void testGetEmployeeList() throws Exception {

    List<Employee> empList = new ArrayList<>();
    Employee emp = new Employee();
    emp.setFirstName("ananth");
    empList.add(emp);

    when(service.getEmployeeList()).thenReturn(empList);

    mvc.perform(get("/employee-list")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].firstName").value("ananth"));
  }

}
