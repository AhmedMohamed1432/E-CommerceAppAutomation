#SC1- User could register with valid data
Feature: User could register with valid data
  Background: User Open browser and navigate to register page
    Given User open browser
    And user navigate to register page


  Scenario: User could register with valid data
    When user enter valid data "Ahmed" , "Fouad", "ahmed12@gmail.com", "pass@1" and "pass@1"
    And user click on register button
    Then user go to successful register page
    When user clicks continue button
    Then user navigate to home page