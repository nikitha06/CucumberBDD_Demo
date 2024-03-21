#Author: Nikitha Bhaskaran
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test Get Default Country details using Rest API Fucntionality

  #@smoke
  Scenario: Successful return of deafult country that should be USA
    Given User is on Spreecom Base URI Home Page
    When User pass the end points using GET keyword
    Then verify response should be "200"
    And verify iso_name should be "UNITED STATES"
