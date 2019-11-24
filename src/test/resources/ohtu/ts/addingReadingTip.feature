Feature: As a user I want to be able to add a reading tip

  Scenario: user can add a book reading tip 
    Given command "add new reading tip" is selected
    When type "book" is given
    And book title "", author "" and ISBN "" are given 
    Then new reading tip is added

