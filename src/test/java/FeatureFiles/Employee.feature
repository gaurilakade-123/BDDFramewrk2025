@Employee
Feature: Test Employee all End points using different http request

  Background: 
    * user set base uri

  @GetSingleEmployee
  Scenario: Retrieve Employee Entity
    Given user set "employees" base path
    And user get the request specification object
    And user add employee id "3" as path parameter
    When user select http get request to retrieve employee single entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs

  @DeleteSingleEmployee
  Scenario: Delete Employee Entity
    Given user set "employees" base path
    And user get the request specification object
    And user add employee id "967b" as path parameter
    When user select http delete request to delete employee single entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs

  @GetAllEmployeeAsPerCondition
  Scenario: Retrieve All Employee Entity
    Given user set "employees" base path
    And user get the request specification object
    And user add employee query parameter "lasNname" and "Jadhav"
    When user select http get request to retrieve all employee entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs

  @GetAllEmployee
  Scenario: Retrieve All Employee Entity
    Given user set "employees" base path
    And user get the request specification object
    When user select http get request to retrieve all employee entity
    Then user get validatable reponse interface object
    And user validate status code 200
    And user validate status line "200 OK"
    And user validate response time 5000 ms
    And user generate response logs
