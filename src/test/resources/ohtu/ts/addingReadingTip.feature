Feature: As a user I want to be able to add a reading tip

  Scenario: user can add a book reading tip 
    Given command "lisää" is selected
    When type "Kirja" is given
    And book title "", author "" and ISBN "" are given 
    Then system will respond with Lukuvinkki lisätty: ""

