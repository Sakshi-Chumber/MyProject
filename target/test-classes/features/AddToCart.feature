
Feature: Add Item to Cart Functionality

  
  Background: User logged in to his account
    Given I am on Homepage this url "https://demoblaze.com/"
   	When I enter valid username and password
    And I click on login button
    Then I should be landed on the homepage



   Scenario: Add to Cart
    Given I should be logged in to his account
    When Click on Laptops under Categories and select any product
    And I should be redirected to Product description page
    And I click on Add to Cart button
    Then Product should be added to cart

