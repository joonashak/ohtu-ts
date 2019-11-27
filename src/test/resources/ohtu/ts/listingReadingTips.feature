Feature: As a user I want to be able to list all reading tips

  Scenario: user can list all reading tips
    Given command "listaa" is selected
    When no filters have been set
    Then system will respond by outputting a list of all the reading tips