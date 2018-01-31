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
    
   Scenario: Check the previous and next button
    Given Launch the URL
    When Click on Detail statement TAB
    Then verify the Next and Previous Button works as expected
    Then Close the application
