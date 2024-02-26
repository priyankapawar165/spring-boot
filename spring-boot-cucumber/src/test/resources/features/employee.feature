Feature: Open API Documentation

  As a developer,
  I want to access the Open API specification
  So I know how to use the application API

  Scenario: Open API specification is made available through default endpoints
    Given application is up
    When customer wants to see a list of employees
    Then I received a list of employees

  Scenario: Add employee
    Given create employee request
    When store into the Database
    Then check if employee details are stored in the database

 Scenario: Update employee
   Given create request to update the employee
   When update existing employee in the database
   Then check if employee details are updated in the database

  Scenario: Delete employee
    Given create request to delete the employee
    When delete existing employee in the database
    Then check if employee deleted from the database