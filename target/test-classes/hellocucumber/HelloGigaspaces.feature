  Feature: Hello Gigaspaces

    Scenario: I trying connect to embedded space write and read from the space
      Given i connected to embedded space
      And I write "Hello" to the space
      When I read from the space
      Then I should get "Hello"