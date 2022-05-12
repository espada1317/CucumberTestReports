Feature: Login procedure

  Scenario: Log in unsuccessfully
    Given I open "https://stackoverflow.com/"
    When I click "Log in" button
    And I write username "trifan.denis1999@gmail.com" and password "qweasd123400"
    And I submit "Log in" button
    Then I get error message

  Scenario: Log in successfully
    Given I open "https://stackoverflow.com/"
    When I click "Log in" button
    And I write username "trifan.denis1999@gmail.com" and password "qweasd1234009"
    And I submit "Log in" button
    Then I am logged to account