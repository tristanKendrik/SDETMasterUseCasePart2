Feature: Testing Restful Web Services

  Scenario: Send a GET request
    Given I send a GET request to "https://jsonplaceholder.typicode.com/posts/1"
    Then the response status code should be 200
    And the response body should contain "\"id\": 1"

  Scenario: Send a POST request
    Given I send a POST request to "https://jsonplaceholder.typicode.com/posts/" with the following JSON:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    Then the response status code should be 201
    And the response body should contain "\"title\": \"foo\""

  # Add similar scenarios for PUT, PATCH, and DELETE requests
