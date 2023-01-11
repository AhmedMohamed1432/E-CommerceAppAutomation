#SC10- Logged user could add different products to Wishlist
@addToWishlist
Feature: Logged user could add different products to Wishlist
  Background:
    Given User open browser


  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters valid login data "ahmed100@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  Scenario: User add products to Wishlist
    When user select Add to Wishlist button
    Then user go to product page
    When user select Add to wishlist button in product page
    Then user success to add selected product to Wishlist