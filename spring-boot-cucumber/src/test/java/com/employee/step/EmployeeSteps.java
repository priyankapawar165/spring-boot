package com.employee.step;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.employee.EmployeeUtil;
import com.employee.repository.EmployeeRepository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.employee.dto.Employee;
import com.employee.service.EmployeeService;
import org.springframework.test.web.servlet.ResultActions;


public class EmployeeSteps {

  @Autowired
  private MockMvc mvc;
  
  @Mock
  private EmployeeService service;

  private ResultActions performedActions;


  @Autowired
  private EmployeeRepository accountRepository;


  @When("customer wants to see a list of employees")
  public void customer_wants_to_see_a_list_of_employees() throws Exception {

    Employee employee = EmployeeUtil.getEmployee();
    this.accountRepository.save(employee);




    performedActions  = mvc.perform(get("/employee-list")
                    .contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
  }

  @Then("I received a list of employees")
  public void iReceiveTheSpecsForTheApplication() throws Exception {
    performedActions.andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$[0].firstName").value("Riya"));
  }
}