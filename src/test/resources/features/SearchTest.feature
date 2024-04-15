Feature: User must be able to search element

  Background:
    Given I am on the search engine home page

  @smoke
  Scenario: User should be able to find one or more articles of my interest
    When I type "Xbox one" on search text field
    And I click on search button
    Then I should see result page visible
    And I should see results that contains text "Xbox one"

  @smoke
  Scenario: User should be able to be notified if there are no articles in the search results.
    When I type "Kornelingonologo" on search text field
    And I click on search button
    Then I should be notified that there are no articles with text "Kornelingonologo"

  @smoke
  Scenario: User should be able to find one or more articles of my interest
    When I type "Microsoft Xbox series X 1 TB Edicion Stand alone" on search text field
    And I click on search button
    Then I should see result page visible
    And I should see the first result with all these words "Microsoft Xbox series X 1 TB Edicion Stand alone"