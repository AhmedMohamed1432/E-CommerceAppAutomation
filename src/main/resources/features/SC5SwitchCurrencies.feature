#SC5- Logged User could switch between currencies US-Euro
@switchCurrencies
Feature: Logged User could switch between currencies US-Euro
  Background:
    Given User open browser

  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters valid login data "ahmed500@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: logged user can change currency
    When user change customer currency
    Then Item price change