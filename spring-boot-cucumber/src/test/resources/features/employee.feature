Feature: Open API Documentation

  As a developer,
  I want to access the Open API specification
  So I know how to use the application API

  Scenario: Open API specification is made available through default endpoints
    Given application is up
    When customer wants to see a list of employees
    Then I received a list of employees
