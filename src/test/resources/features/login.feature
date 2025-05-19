Feature: Login functionality

  As a user of the web application
  I want to be able to log in with valid credentials

  @TC01
  Scenario: Successful login with valid credentials
    Given I open the login page
    When I enter a valid company
    And I enter a valid user email
    And I enter a valid password
    And I click the login button
    Then I should see the User Icon in the top bar

  @TC02
  Scenario: Try to login with invalid user email
    Given I open the login page
    When I enter a valid company
    And I enter the email "invalid@email.com"
    And I enter a valid password
    And I click the login button
    Then I should see an invalid credentials alert
    And The alert text should be "Invalid login credentials."

  @TC03
  Scenario: Try to login with invalid password
    Given I open the login page
    When I enter a valid company
    And I enter a valid user email
    And I enter the password "invalidP@ssword"
    And I click the login button
    Then I should see an invalid credentials alert
    And The alert text should be "Invalid login credentials."

  @TC04
  Scenario: Try to login with an empty company field
    Given I open the login page
    When I enter a valid user email
    And I enter a valid password
    And I click the login button
    Then I should see the required company alert

  @TC05
  Scenario: Try to login with an empty user email field
    Given I open the login page
    When I enter a valid company
    And I enter a valid password
    And I click the login button
    Then I should see the required email alert

  @TC06
  Scenario: Try to login with an empty password field
    Given I open the login page
    When I enter a valid company
    And I enter a valid user email
    And I click the login button
    Then I should see the required password alert
