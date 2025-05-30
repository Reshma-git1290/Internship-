#Feature: Login functionality for multiple users
#
#  Scenario Outline: Login with different user credentials
#    Given the user is on the login page
#    When the user logs in with username "<username>" and password "<password>"
#    Then the login should be "<status>"
#
#    Examples:
#      | username        | password     | status  |
#      | locked_out_user | secret_sauce | fail    |
#      | problem_user    | secret_sauce | success |
#      | standard_user   | secret_sauce | success |
#
