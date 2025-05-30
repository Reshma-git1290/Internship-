@ProfileFeature
Feature: Profile Page Functionality

  Background:
    Given User is logged in and navigates to the profile page

  @Positive
  Scenario: User navigates to the profile page
    Then Profile page should be displayed
#
#  @Positive
#  Scenario: User clicks on Personal Info and views details
#    When User clicks on Personal Info
#    Then Personal Info section should be displayed
#
#  @Positive
#  Scenario: User updates phone number successfully
#    When User clicks on Change
#    And User updates phone number with "9876543210"
#    And User clicks on Save Changes
#    Then Success message should be displayed
#    And Phone number should be updated to "9876543210"
#
#  @Negative
#  Scenario: User submits empty phone number
#    When User clicks on Change
#    And User updates phone number with ""
#    And User clicks on Save Changes
#    Then Error message "Phone number is required" should be displayed
#
#  @Negative
#  Scenario: User enters invalid phone number format
#    When User clicks on Change
#    And User updates phone number with "abc123"
#    And User clicks on Save Changes
#    Then Error message "Invalid phone number format" should be displayed
#
#  @Negative
#  Scenario: User cancels the update
#    When User clicks on Change
#    And User updates phone number with "1234567890"
#    And User clicks on Cancel
#    Then Phone number should not be updated to "1234567890"
