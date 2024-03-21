#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test Create Address functionality


  Background: Successful Generation of Token with Valid email_ID and Password
    Given User send POST request for CreateToken using Base URI
    When User Enter the Body data as email id "nice@spree.com" and password "spree123"
    Then verify it successfully generated the response with status code "200"
    And verify token return from server
  @smoke
  Scenario: Successful creation of Address with Valid details
    Given User send POST request for Create Address
    When User Enter address details data through Body
    Then verify it successfully generated the response with status code "200"
    And verify the first and lastname of address returned by server