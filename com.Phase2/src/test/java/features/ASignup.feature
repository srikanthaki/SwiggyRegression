Feature: Login functionality in swiggy website

  
  Scenario Outline: Provide signup feature to the user so that end user able to login
    Given User is having swiggy home page opened
    When User are able to verify singup form
    Then User should able to Enter "<Phonenumber>","<Name>","<email>","<Password>"
    And User should able to signup

    Examples: 
      | Phonenumber | Name | email          | password |
      |  9999999999 | sri  | saki@gmail.com | star     |
