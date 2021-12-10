Feature: Monster Notebook Tests

  Background:
    Given  User Navigates to G2A

  @positive
  Scenario Outline:
    When User should enter user information and try to login. "<email>" "<password>"
    Then User should see the new menu when clicks account button.
    And User makes search. "<itemname>"
    Then User adds first result to the basket.

    Examples:
      | email                 | | password     | itemname |
      |burakbtestdata@yandex.com| |147258369b| kulaklık |
      |burakbtestdata@yandex.com| |147258369b| mousepad |
      |burakbtestdata@yandex.com| |147258369b| soğutucu |


  @negative
  Scenario Outline:
    When User should enter user information and try to login. "<email>" "<password>"
    Then User should see the new menu when clicks account button.
    And User makes search. "<itemname>"
    Then User faces bad search page.

    Examples:
      | email                 |   | password     | itemname |
      |burakbtestdata@yandex.com| |147258369b  | qqqqqqqqqq |
      |burakbtestdata@yandex.com| |147258369b  | thiscannotexist |

  @negative
  Scenario Outline:
    When User should enter user information and try to login. "<email>" "<password>"
    Then User should not directed from sign-in form.

    Examples:
      | email                 | | password     |
      |burakbtestdata@yandex.com | |wrongpw1 |
      |burakbtestdata@yandex.com | |wrongpw2 |



