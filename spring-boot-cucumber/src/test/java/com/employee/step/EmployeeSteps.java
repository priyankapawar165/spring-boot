package com.employee.step;

import com.employee.EmployeeUtil;
import com.employee.dto.Employee;
import com.employee.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeSteps {

  @Autowired
  private MockMvc mvc;

  private ResultActions performedActions;

  @Autowired
  private EmployeeRepository employeeRepository;

  Employee employee =  null;
  Optional<Employee> exitingEmployee = null;
  @When("customer wants to see a list of employees")
  public void customer_wants_to_see_a_list_of_employees() throws Exception {

    Employee employee = EmployeeUtil.getEmployee();
    this.employeeRepository.save(employee);

    performedActions  = mvc.perform(get("/employee-list")
                    .contentType(APPLICATION_JSON))
            .andDo(print());
  }

  @Then("I received a list of employees")
  public void iReceiveTheSpecsForTheApplication() throws Exception {
    performedActions.andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$[0].firstName").value("Riya"));
  }

  @Given("create employee request")
  public void create_employee_request() {
   employee = new Employee();
   employee.setFirstName("Priyanka");
   employee.setEmailAddress("test@gmail.com");
  }
  @When("store into the Database")
  public void store_into_the_database() {
 employeeRepository.save(employee);
  }
  @Then("check if employee details are stored in the database")
  public void check_if_employee_details_are_stored_in_the_database() throws Exception {

     mvc.perform(get("/employee-list")
                    .contentType(APPLICATION_JSON))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$[1].firstName").value("Priyanka"));
  }

  @Given("create request to update the employee")
  public void create_request_to_update_the_employee() {
    exitingEmployee  = employeeRepository.findById(1);
    exitingEmployee.get().setFirstName("Dhara");
  }
  @When("update existing employee in the database")
  public void update_existing_employee_in_the_database() throws Exception {
    mvc.perform(post("/employee-add")
                    .contentType(APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(exitingEmployee.get())))
            .andExpect(status().isOk());


  }
  @Then("check if employee details are updated in the database")
  public void check_if_employee_details_are_updated_in_the_database() throws Exception {

    mvc.perform(get("/employee-list")
                    .contentType(APPLICATION_JSON))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$[0].firstName").value("Dhara"));
  }

    @Given("create request to delete the employee")
    public void create_request_to_delete_the_employee() {
        //exitingEmployee  = employeeRepository.findById(2);
       //exitingEmployee.get().setId(1);
    }
    @When("delete existing employee in the database")
    public void delete_existing_employee_in_the_database() throws Exception {
        mvc.perform(delete("/employee-delete/1")
                        .contentType(APPLICATION_JSON))
                      //  .content(new ObjectMapper().writeValueAsString(exitingEmployee.get().getId())))
                .andExpect(status().isOk());

    }
    @Then("check if employee deleted from the database")
    public void check_if_employee_deleted_from_the_database() throws Exception {
        ResultActions  resultActions=  mvc.perform(get("/employee-list")
                        .contentType(APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).
       andExpect(jsonPath("$[0].firstName").value(not(equalTo("R"))));



        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();


       // assertEquals("", contentAsString);
       // ObjectMapper objectMapper = new ObjectMapper();
       // List<Employee> response = Collections.singletonList(objectMapper.readValue(contentAsString, Employee.class));
       // assertEquals("", response.get(0).getId());


      //  result.andExpect(jsonPath("$.your.json.path").value(not(equalTo("expected-value"))));


    }
}