Feature: Add product to cart
  As a guest user
  I want to try buying a product
  So that I see the behaviour of the cart

  Scenario: Buy two units of the same product online
    Given Maria wants to start buying a product selecting the category Perfumes and the subcategory Maderosa
    When Maria adds the product Element and she wants buying it
    And Maria cancels the purchase
    Then Maria should see the purchase canceled


