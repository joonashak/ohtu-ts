Feature: As a user I want to be able to list all reading tips

Scenario: user can list all reading tips
    Given command "lisää" is selected
    And type "Kirja" is given
    And book title "title1", author "author1" and ISBN "isbn-1" are given
    And command "lisää" is selected
    And type "Kirja" is given
    And book title "title2", author "author2" and ISBN "isbn-2" are given
    When command "listaa" is selected
    Then system will respond first with "Tyyppi: Kirja, Otsikko: title1, Kirjoittaja: author1, ISBN: isbn-1"
    And system will respond second with "Tyyppi: Kirja, Otsikko: title2, Kirjoittaja: author2, ISBN: isbn-2"