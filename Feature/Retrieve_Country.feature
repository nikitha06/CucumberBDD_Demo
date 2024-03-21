#Author: Nikitha Bhaskaran
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test Get Default Country details using Rest API Fucntionality

  #@smoke
Scenario: Successful Search with Valid Input of Country
	Given User is on RestCountries URI Home Page
	When User Enter the keyword "USA"
	Then verify body of the message to see what response return from server
	And verify Status code return from server
	And verify Status Line return from server
