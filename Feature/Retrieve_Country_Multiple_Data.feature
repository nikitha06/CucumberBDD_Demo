#Author: Nikitha Bhaskaran
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test different Country details

  Scenario Outline: Successful Search with Valid Input of Country
    Given User is on RestCountries URI Home Page
    When User Enter the keyword from datatable "<iso>"
    Then verify body of the message to see what response return from server
    And verify Status code return from server
    And verify iso_name return "<iso_name>" from server

    Examples: With Multiple Data
      | iso | iso_name       |
      | ind | INDIA          |
      | gb  | UNITED KINGDOM |
      | pak | PAKISTAN       |
