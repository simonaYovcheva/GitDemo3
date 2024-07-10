Feature: User Login

  @loginTest
  Scenario Outline: Test login functionality
    Given the user is on the login page
    When the user enters "<email>" and "<password>"
    Then the login should be "<expectedResult>"

    Examples:
      | email                | password         | expectedResult                          |
      | Ow2432@pek.com       | parola123!       | My Account                              |
      | Ow2432@pek.com       |                  | Warning: No match for E-Mail Address... |
      | invalid-email        | parola123!       | Warning: No match for E-Mail Address... |
      |                      | parola123!       | Warning: No match for E-Mail Address... |
      | invalid-email        | invalid-password | Warning: No match for E-Mail Address... |
      |                      |                  | Warning: No match for E-Mail Address... |
