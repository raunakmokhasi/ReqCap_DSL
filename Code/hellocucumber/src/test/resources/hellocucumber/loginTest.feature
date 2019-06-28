Feature: Reset functionality on login page of Application


  Scenario: Verification of Reset button


    Given Open the Chrome Browser and launch the application


    When Enter the Username and Password
    And Reset the credential


    Then Username and Password is empty

