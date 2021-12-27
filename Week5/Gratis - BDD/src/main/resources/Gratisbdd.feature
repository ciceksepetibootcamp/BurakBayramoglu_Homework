Feature: Gratis BDD Tests

  Background:
    Given  User Opens Gratis Application

  @positive
  Scenario: Succes Login
    When User should enter user information and try to login. "burakbtestdata@yandex.com" "147258369Bb."
    And User should redirected to basket page and face a popup.
    Then User should see empty basket message. "Sepetin şu an boş"

  @negative
  Scenario Outline: Failed Login
    When User should enter user information and try to login. "<email>" "<password>"
    And User should not redirected to basket page and should not face a popup.
    Examples:
      | email                     | password |
      | burakbtestdata@yandex.com | wrongpw1 |



  @positive
  Scenario: Success Add Item To Basket
    When User should enter user information and try to login. "burakbtestdata@yandex.com" "147258369Bb."
    And User should redirected to basket page and face a popup.
    And User should make search. "Oje"
    And User should add an item to the basket.
    Then User should see one item at the basket.

  @positive
  Scenario: Success Remove Item From Basket
    When User should enter user information and try to login. "burakbtestdata@yandex.com" "147258369Bb."
    And User should redirected to basket page and face a popup.
    And User should make search. "Oje"
    And User should add an item to the basket.
    And User should remove item from basket.
    Then User should see empty basket message. "Sepetin şu an boş"

