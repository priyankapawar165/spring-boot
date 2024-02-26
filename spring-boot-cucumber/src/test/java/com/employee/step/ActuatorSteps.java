package com.employee.step;
import com.employee.service.EmployeeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ActuatorSteps {

    @Autowired
    protected MockMvc mvc;
    @MockBean
    private EmployeeService service;

    private ResultActions performedActions;


    @Given("application is up")
    public void applicationIsUp() throws Exception {
        mvc.perform(get("/actuator/health"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("UP")));
    }



/**
    @When("@When(\"customer wants to see a list of employees\")")
    public void receivedResult() throws Exception {

        performedActions  = mvc.perform(get("/employee-list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

    }

    @Then("I received a list of employees")
    public void iReceiveTheSpecsForTheApplication() throws Exception {
        performedActions.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName").value("ananth"));
    }

**/
}