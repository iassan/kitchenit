Feature: Shopping lists

  Scenario: User can create shopping list
    Given a logged in user u
    And a shopping list's name n
    When the user requests new shopping list created with that name
    Then a new shopping list with given name is created for the user

  Scenario: User can add item to the shopping list
    Given a logged in user u
    And a shopping list
    When the user requests adding item i with quantity q to the list
    Then a new item is added to the list

