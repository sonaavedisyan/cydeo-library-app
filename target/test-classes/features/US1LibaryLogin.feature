@wip@librarianLogin
Feature: As a user, i should be able to login in library CT

  Scenario: librarian happy path login


Given "librarian" is on the LoginPage
Then verify the title is "Login - Library"
When "librarian" enters valid email and password
And "librarian" clicks "sign in button"
Then verify that there are 3 modules on the page

    Scenario: student LoginPage happy path

    Given "student" is on the LoginPage
    Then verify the url is "https://library2.cydeo.com/login.html"
    When "student" enters valid email and password
    And "student" clicks "sign in button"
    Then verify that there are 2 modules on the page

      Scenario: Negative login page

    Given "user" is on the LoginPage
    When "user" enters invalid/valid email and password
    And "user" clicks "sign in button"
    Then verify that the error message "Sorry, Wrong Email or Password"