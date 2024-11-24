Feature: New User Registration

  Scenario Outline: Validate new user successfully registers in the application
    Given User launch Chrome browser
    When User open URL "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    When User click on humburger menu
    And User click on signin portal link
    And User click on NewUserRegistrationLink
    And User enter the details as follows:
      | firstName   | lastName   | email   | Mobile   | userName   | password   |
      | <firstName> | <lastName> | <email> | <Mobile> | <userName> | <password> |
    And User click on submit button
    Then User see successful message on the page
    And User close browser

    Examples: 
      | firstName | lastName | email                  | Mobile     | userName | password  |
      | John      | Doe      | john.doe@example.com   | 1234567890 | ankit    | pass1234  |
      | Jane      | Smith    | jane.smith@example.com | 0987654321 | deepak   | password1 |
