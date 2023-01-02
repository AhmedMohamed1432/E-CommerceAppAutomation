#SC7- Logged user could filter with color
@filterWithColor
Feature: Logged user could filter with color
  Background:
    Given User open browser

  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters "ahmed1@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: Logged user filter with color
    When user selects color
    Then user see products with selected colors