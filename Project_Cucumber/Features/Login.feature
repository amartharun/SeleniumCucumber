Feature: Login

  Scenario: Succeddfull Login with Credentials
    Given user launch chrome browser
    When user open "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then page title should be "Your store. Login"
    And close browser

  Scenario Outline: Succeddfull Login with Credentials
    Given user launch chrome browser
    When user open "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "<email>" and password as "<password>"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then page title should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin12  |
