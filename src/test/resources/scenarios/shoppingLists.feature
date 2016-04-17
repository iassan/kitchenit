Feature: Shopping lists

  Scenario: User can create shopping list
    Given a logged in user
    And a shopping list's name
    When the user requests new shopping list created with that name
    Then a new shopping list with given name is created for the user

  Scenario: User can add item to the shopping list
    Given a logged in user
    And a shopping list
    And the user has rights to modify this list
    When the user requests adding quantity of item to the list
    Then this new item is added to the list with given quantity

