Feature: Shopping lists

  Scenario: User can create shopping list
    Given a logged in user u
    And a shopping list's name n
    When the user requests new shopping list created with that name
    Then a new shopping list with given name is created for the user
