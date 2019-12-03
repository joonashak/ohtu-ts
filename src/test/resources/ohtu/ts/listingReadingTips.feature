Feature: As a user I want to be able to list all reading tips


Scenario: user can list all reading tips
    Given command "1" is selected
    And type "1" is given
    And book title "title1", author "author1" and ISBN "isbn-1" are given
    And command "1" is selected
    And type "1" is given
    And book title "title2", author "author2" and ISBN "isbn-2" are given
    When command "2" is selected
    Then system will respond with a list that contains at least the titles "title1" "title2"


