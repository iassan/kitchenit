Feature: Shopping lists

  Scenario: User can create shopping list
    Given a shopping list's name
    When the user requests new shopping list created with that name
    Then a new shopping list with given name is created

  Scenario: User can delete shopping list
    Given a shopping list
    When the user requests deleting the list
    Then this list is deleted

  Scenario Outline: User can add item to the shopping list
    Given a shopping list
    And an item
    And this list contains <quantity> of this item
    When the user requests adding <new quantity> of this item to the list
    Then the list contains <final quantity> of this item
    Examples:
      | quantity | new quantity | final quantity |
      | 0        | 1            | 1              |
      | 1        | 1            | 2              |

  Scenario: User can remove an item from the list
    Given a shopping list
    And this list contains the item
    When the user requests removing the item from the list
    Then the list no longer contains the item
