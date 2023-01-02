#SC6- Logged user could select different Categories
@selectCategories
Feature: Logged user could select different Categories
  Background:
    Given User open browser

  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters "ahmed1@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: Logged user can select categories
    When user hover to Computers
    And user select Notebooks category
    Then user go to Notebooks category page

