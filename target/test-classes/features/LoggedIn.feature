Feature: LoggedIn User View

  Scenario: Validate user able to access the application with valid credential
    Given User launch Chrome browser
    When User open URL "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    When User click on humburger menu
    And User click on signin portal link
    And User enter the username
    And User enter the password
    And User click on login button
    Then User able to see the products
    And User close browser

  Scenario Outline: Validate user to access the application with valid credential with multiple set pf data
    Given User launch Chrome browser
    When User open URL "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    When User click on humburger menu
    And User click on signin portal link
    And User enter credentail username as "<username>" and password as "<password>"
    And User click on login button
    Then User able to see the products
    And User close browser

    Examples: 
      | username | password  |
      | user1    | pass123   |
      | admin    | adminPass |
