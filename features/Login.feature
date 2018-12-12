
Feature: Test the login functionality on GitHub

  Scenario: User should be able to login with correct username and correct password
    Given user is on login page
    When user enters correct username and correct password
    Then user gets confirmation