Feature: Verify List of restaurants

 
  Scenario Outline: User able get list of restaurants in the homepage
    Given User is on swiggy home page opened
    When User entered delivery location "<location>"
    Then user able to get the list of restaurants avalable in the respective location

    Examples: 
      | location |
      | kakinada |