#SC4- Logged User could search for any product
@search
  Feature: Logged User could search for any product
    Background:
      Given User open browser


    Scenario: User could login with valid email and password
      Given user navigate to login page
      When user enters "ahmed1@gmail.com", and "pass@1"
      And user clicks login button
      Then user login success and navigate to home page

    Scenario: logged user search
      Given user enters "Apple MacBook" in search field
      When user press search button
      Then product is displayed


