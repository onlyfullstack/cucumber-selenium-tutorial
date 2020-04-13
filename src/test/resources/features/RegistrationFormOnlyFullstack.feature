Feature: Registration Form

  Background:
    Given I am on the Registration page

  Scenario: Verify title
    Then I verify that title with Only Fullstack Developer

  Scenario: Submit the form without any values
    When I click on submit form button
    Then I verify that the error messages of each input

  Scenario: Submit the form with valid values
    When I Enter valid values in registration form
    Then I click on submit form button1
    And I verify the success message content
    And I click on Ok button

  Scenario: Submit the form with invalid mobile number values
    When I Enter invalid mobile number as QWERTYU in registration form
    And I click on submit form button1
    Then I verify the error message of mobile number

  Scenario Outline: Submit the form with invalid Zip Code
    When I Enter invalid Zip Code as <zip_code> in registration form
    And I click on submit form button1
    Then I verify the error message of Zip Code
    Examples:
    | zip_code |
    | ABCDS    |
    | 123      |
    | AA!*&    |