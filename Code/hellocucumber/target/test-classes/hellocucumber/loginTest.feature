Feature: Login functionality on login page
  Scenario: Verification of Correct Login
    Given Open the Chrome Browser and launch the Login page
    When Enter Raunak as Username and Mokhasi as Password
    And Click the login button
    Then Log the user in and load Quotes page
  Scenario: Verification of Invalid Login
    Given Open the Chrome Browser and launch the Login page
    And Click the login button
    Then Show invalid login alert
  Scenario: Verification of Get Quote button
    Given Open the Chrome Browser and launch the Login page
    When Click Get Quote button
    Then Show quote in alert