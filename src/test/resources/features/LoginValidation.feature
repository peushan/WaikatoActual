Feature: Facebook Login feature

  Scenario: Login To facebook Pages
    Given I have open the browser
    When I login to the application using "email" and "password"
    Then Welcome page should be displayed


#  Scenario Outline: Login To facebook Pages
#    Given I have open the browser
#    When I login to the application using <email> and <password>
#    Then Welcome page should be displayed
#    Examples:
#      | email                     | password  |
#      | peusanpanagdoa@gmaila.com | iasiasajk |
#      | test                      | test123   |
#
#  Scenario Outline: Login To facebook Pages
#    Given I have open the browser
#    When I login to the application
#    |email|<email>|
#    |password|<password>|
#    Then Welcome page should be displayed
#    Examples:
#      | email                     | password  |
#      | peusanpanagdoa@gmaila.com | iasiasajk |
#      | test                      | test123   |