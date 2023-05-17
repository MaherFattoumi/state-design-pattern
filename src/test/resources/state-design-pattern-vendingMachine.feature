Feature: Vending Machine

  Scenario: Dispense item when in idle state
    Given a vending machine in idle state
    When a user selects an item
    Then the vending machine should dispense the selected item

  Scenario: Cannot dispense item when in dispensing state
    Given a vending machine in dispensing state
    When a user selects an item
    Then the vending machine should not dispense the selected item
