Feature: App Login Page

  Scenario: Test to check the correct Account Page
      When User Launches App Login Page
     Then User should land on Correct Page

  Scenario: To Verify if "Already have an account? Sign in" Text is visible
      When User is on App Login Page2
     Then Already have an account? Sign in" Text should be visible

  Scenario: To Verify if "Happy parkers make happy people" Text is visible
      When User is on App Login Page3
     Then Happy parkers make happy people" Text should be visible

  Scenario: To Verify if "Sign in with Google" Button is visible
      When User is on App Login Page4
     Then Sign in with Google" Button should be visible

#  Scenario: To Verify if "Sign in with Google" Button is Working
#      When User Clicks on Sing in with Google Button
#     Then User should redirect to accounts.google.com link

    Scenario: To Verify if "Sign in with SSO" Button is visible
      When User is on App Login Page6
     Then Sign in with SSO Button should be visible

    Scenario: To Verify if "or" text is visible
      When User is on App Login Page7
     Then or Text Should be visible after SSO login button

    Scenario: To Verify if "Email" label is visible
      When User is on App Login Page8
     Then Email Text Should be visible above Email Field box

    Scenario: To Verify if "Email" field box  is visible
      When User is on App Login Page9
     Then Email field should be visible

     Scenario: To Verify if Email Place Holder is Visible
      When User is on App Login Page10
     Then Email placeholder you@example.com should be visible

     Scenario: To Verify if Forgot Password Link is Visible
      When User is on App Login Page11
     Then Forget Password Link should be visible

     Scenario: To Verify if Forgot Password Link text is Forgot Password?
      When User is on App Login Page12
     Then Forget Password Link text should be Forgot Password?

     Scenario: To Verify if "Password" label is visible
      When User is on App Login Page13
     Then Password label should be Password

     Scenario: To Verify if "Check box" is visible
      When User is on App Login Page14
     Then Check box should be visible

     Scenario: To Verify if Show Password Check is working
      When Checkbox is clicked
     Then Checkbox functionality should work

     Scenario: To Verify if "Show Password" Check box text is visible
      When User is on App Login Page15
     Then On Checkbox show password text should be visible

#     Scenario: To Verify if Remember me "Radio" button is visible
#      When User is on App Login Page16
#     Then Remember me radio button should be visible

     Scenario: To Verify if Remember me text is visible
      When User is on App Login Page17
     Then Remember me text should be visible

     Scenario: To Verify if "Sign in" button is visible
      When User is on App Login Page18
     Then Sign in button should be visible

     Scenario: To Verify if the "Didn't receive confirmation instructions?" button is visible
      When User is on App Login Page19
     Then Didnt receive confirmation instructions?" button should be visible

     Scenario: To Verify if the "Didn't receive confirmation instructions?" button is working
      When User is on App Login Page20
     Then Didnt receive confirmation instructions?" button should be working

     Scenario: To Verify if the "Didn't receive unlock instructions?" button is visible
      When User is on App Login Page21
     Then Didnt receive unlock instructions? button should be visible

     Scenario: To Verify if the "Didn't receive unlock instructions?" button is working
      When User is on App Login Page22
     Then Didnt receive unlock instructions? button should be working

    ############################################################################
    ## Login Functionality
  #Feature: Wayleadr User and Password Login Functionality

  Scenario: Test login with Correct Username and Password
      When User Input Correct Credentials
      Then User Logs in Successfully

  Scenario: Test Login with Correct Username and Incorrect Password
      When User Input correct Username and Incorrect Password Credentials
      Then User should get Login Error1

  Scenario: Test Login with Incorrect Username and Correct Password
      When User Input Correct Username and Incorrect Password Credentials
      Then User should get Login Error2

  Scenario: Test Login with Incorrect Username and Incorrect Password
    When User Input Incorrect Username and Incorrect Password
    Then User Should get Login Error3

   ############################################################################



