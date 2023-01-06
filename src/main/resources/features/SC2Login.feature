#SC2- User could log in with valid email and password
@login
  Feature: User could login with valid email and password

    Background: user open browser and go to login page
      Given User open browser



    @First
    Scenario: User could register with valid data
      Given user navigate to register page
      When user enter valid data "Ahmed" , "Fouad", "ahmed50@gmail.com", "pass@1" and "pass@1"
      And user click on register button
      Then user go to successful register page
      When user clicks continue button
      Then user navigate to home page

    @Second
    Scenario: User could login with valid email and password
      Given user navigate to login page
      When user enters valid login data "ahmed50@gmail.com", and "pass@1"
      And user clicks login button
      Then user login success and navigate to home page


