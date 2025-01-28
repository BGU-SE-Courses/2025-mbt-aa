# Feature: A set of scenarios for testing the "example" module

#   Scenario: Testing how a case where a user adds a product to the cart
#     Given an example scenario
#     When all step definitions are implemented
#     Then the scenario passes

Feature: Student subscribes to a forum discussion, Teacher deletes this discussion

  Scenario Outline: Student subscribes to a forum discussion
    Given Student is on Home page
    And Student is logged in with "<username>" and "<password>"
    And Student is on courses page
    And Student has a course
    And Course has a forum discussion
    When Student subscribes to a forum discussion
    Then The student successfully subscribed to the discussion

    Examples:
      | username | password    |
      | student  | Student123! |

#    Scenario Outline: Teacher deletes this discussion
#      Given Student is on Home page
#      And Teacher is logged in with "<username>" and "<password>"
#      And Teacher is on courses page
#      And Teacher has a course
#      And Course has a forum discussion
#      And Teacher in specific forum discussion page
#      When Teacher deletes a forum discussion
#      Then The Teacher successfully deletes the discussion
#
#      Examples:
#        | username | password    |
#        | Teacher  | Teacher123! |

