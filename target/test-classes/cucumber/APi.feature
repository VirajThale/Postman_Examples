Feature: Rest Assure Feature

  Scenario: To verify the get Operation
    Given I have the base URI "http://localhost:7000/employees"
    When I perform th Get Operation
    Then I should get the response
    And Response code should be 200
