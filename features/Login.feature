Feature: Test the login functionality on GitHub

  Scenario: User should be able to login with correct username and correct password
    Given user is on login page
    When user enters correct username and correct password
    Then user gets confirmation

  Scenario Outline: the user should be able to login
    Given user is on login page
    When user enters email <username>
    And user enters password <password>
    Then user gets confirmation

    Examples:
      | username          | password |
      | tim@testmail.com  | trpass   |
      | rw@testmail.com   | rwpass   |
      | jv@t3testmail.com | jvpass   |









