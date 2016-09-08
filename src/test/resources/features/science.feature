Feature: Search google for Science

  Scenario: Google Test
    Given we access search page
       When I search for Science
    Then a page with Science should be displayed
    And a Science wiki page should be displayed