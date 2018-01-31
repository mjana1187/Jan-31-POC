Feature: POC Application

  Background: 
    Given Launch the URL

  Scenario: Click on MINI statement TAB
    When Click on Mini statement TAB
    Then Mini statement should get generated successfully
    Then Close the application

  Scenario: Click on Detail Statement TAB
    Given Launch the URL
    When Click on Detail statement TAB
    Then Default Detail statement should get generated successfully
    Then Close the application

  Scenario: Validate MINI Statement
    Given Launch the URL
    When Click on Mini statement TAB
    Then Mini statement should get generated successfully
    Then Validate the mini statement generated against the data from DB
    Then Close the application

  Scenario: Validate Detailed statement
    Given Launch the URL
    When Click on Detail statement TAB
    Then Default Detail statement should get generated successfully
    Then Validate the Detailed statement against the data from DB
    Then Close the application

  Scenario: Validate Detailed statement with valid transaction dates
    Given Launch the URL
    When Click on Detail statement TAB
    Then Detailed statement should get generated for valid transaction dates
    Then Validate the Detailed statement against the data from DB
    Then Close the application

  Scenario: Negative Scenario for Detailed statement
    Given Launch the URL
    When Click on Detail statement TAB
    Then provide Future date in From date
    Then there should not be any transactions shown
    Then Close the application

  Scenario: Negative Scenario for Detailed statement
    Given Launch the URL
    When Click on Detail statement TAB
    Then Provide TO date lesser to FROM date
    Then there should not be any transactions shown
    Then Close the application

  Scenario: Verify Detailed statement details with database
    Given Launch the URL
    When Click on Detail statement TAB
    Then Verify the detailed statement generated against data from DB
    Then Close the application

  Scenario: Check the previous and next button
    Given Launch the URL
    When Click on Detail statement TAB
    Then verify the Next and Previous Button works as expected
    Then Close the application
