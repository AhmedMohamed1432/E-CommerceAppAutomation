#SC11- Logged user could add different products to compare list
@addCompareList
Feature: Logged user could add different products to compare list
  Background:
    Given User open browser


  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters valid login data "ahmed100@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: User add products to compare list
    When user select Add to compare list button
    Then user success to add selected product to compare list