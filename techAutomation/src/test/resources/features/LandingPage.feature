@test
Feature: Ability to select summer dresses, add and remove item from cart
  As a user
  I want to navigate to automation practice website
  so that I can add an item to the cart
  and I can remove items from cart

  Background: Adding and removing items from cart
    Given I navigate to automation practice website
    And I select women category
    And I navigate to dresses section

  Scenario: Adding and removing item from cart
    And I select summer dresses category
    And I sort dress prices from low to high
    And I select a random dress
    And I add the dress to basket
    And I click proceed to checkout button
    And product has been added to cart summary page
    When I click the delete icon
    Then Item is removed from cart

  Scenario: Adding a second item to the basket
    Given I have added the second item
    When I click proceed to checkout button
    Then product has been added to cart summary page


