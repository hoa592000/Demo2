Feature: Web login
  Scenario: Login to homepage with user incorrect
    Given User go to page
    When User login into application with "thanhhoa592000@gmail.com" and password "Chaizo7^^"
    Then Home page is populated with "* Incorrect username or password"
    And Close app

