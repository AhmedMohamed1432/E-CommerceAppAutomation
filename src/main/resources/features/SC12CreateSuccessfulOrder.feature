#SC12- Create successful Order
@createSuccessfulOrder
Feature: Logged user could add different products to compare list
  Background:
    Given User open browser

  #login
  Scenario: User could login with valid email and password
    Given user navigate to login page
    When user enters "ahmed1@gmail.com", and "pass@1"
    And user clicks login button
    Then user login success and navigate to home page

  #add to shopping cart
  Scenario: User add products to Shopping cart
    When user select Add to cart button
    Then user go to product page
    When user select Add to cart button in product page
    Then user success to add selected product to Shopping cart

  #Complete order
  Scenario: User could create successful Order
    Given user go to shopping cart page
    When user check terms of service checkbox
    And user press checkout button
    Then user go to billing page

    When user fill data
    And user click continue button
    
    Then user go to shipping page


    When press continue button in shipping page
    Then user go to payment method page

    When user click continue button in payment method
    Then user go to payment information page

    When user click continue button in payment information
    Then user go to confirm order page

    When user click on confirm button in confirm order
    Then user see complete successful order

    When user click continue button in complete successful order
    Then user go to home page again