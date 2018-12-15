Feature: Test the sign up functionality on GitHub

  Scenario Outline: User should be able to create a new account
    Given user is on main page
    When user enters new username <username>
    And user enters new email <email>
    And user enters new password <password>
    Then user sees welcome message

    Examples:
      | username     | email             | password |
      | tim@testmail | tim@testmail.com  | trpass   |
      | rw@testmail  | rw@testmail.com   | rwpass   |
      | jvt3         | jv@t3testmail.com | jvpass   |
