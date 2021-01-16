Feature: Verify List of options on swiggy home page

  Background: 
    Given User is having swiggy home page
    When User entered delivery location "kakinada"

  Scenario Outline: User able to sort all type of options
    When User click on Costfortwo tab
    Then Costfortwo filter  should be Applied

    Examples: 
      | place    |
      | kakinada |