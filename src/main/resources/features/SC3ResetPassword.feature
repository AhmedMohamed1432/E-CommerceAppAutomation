#SC3- User could reset his/her password successfully
@resetPassword
  Feature: User could reset his/her password successfully
    Background: user open browser and go to login page

    Scenario: User could reset his/her password
      Given user press forgotPassword link
      When user enters reset email "Ahmed50@gmail.com"
      And user click reset button
      Then success message is displayed
