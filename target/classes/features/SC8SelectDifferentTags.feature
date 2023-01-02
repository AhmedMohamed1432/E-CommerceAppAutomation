#SC8- Logged user could select different tags
@selectDifferentTags
Feature: Logged user could select different tags
  Background:
    Given User open browser


  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters "ahmed1@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: User  select different tags
    Given user navigate to product tags
    When user select product tag
    Then user go to selected product tag page