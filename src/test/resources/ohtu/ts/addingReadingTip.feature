Feature: As a user I want to be able to add a reading tip

  Scenario: user can add a book reading tip 
    Given command "1" is selected
    When type "1" is given
    And book title "title", author "author" and ISBN "isbn" are given 
    Then system will respond with "Lukuvinkki lisätty!"
