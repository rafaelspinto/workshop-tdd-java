Feature: Calculator
  The calculator supports the sum operation.

  Scenario: Adding positive numbers
    Given I use a calculator
    When I add positive numbers
    Then The result should be positive

  Scenario: Adding negative numbers
    Given I use a calculator
    When I add negative numbers
    Then The result should be negative

  Scenario: Adding negative numbers
    Given I use a calculator
    When I add opposite numbers
    Then The result should be zero