Feature: As a user I want to be able to open my browser directly from the app


    Scenario: User can open a browser from the details view on linux
        Given command "1" is selected
        And type "2" is given
        And video title "title" and URL "google.com" are given
        And command "2" is selected
        And command "1" is selected
        And command "b" is selected
        Then the correct command will be run in the terminal on linux
