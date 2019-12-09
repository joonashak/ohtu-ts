Feature: As a user I want to be able see all information of one chosen reading tip from the list


Scenario: user can open reading tip from the list
    Given command "1" is selected
    And type "1" is given
    And book title "title", author "author" and ISBN "1234" are given
    And command "2" is selected
    When command "1" is selected
    Then system will respond with book's information: title "title", author "author" and ISBN "1234"
