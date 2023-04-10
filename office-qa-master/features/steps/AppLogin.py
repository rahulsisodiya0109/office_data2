import time

from behave import *
from selenium.webdriver.common.by import By
from PageObjects.AppLogin_Page import AppLogin, Office_User_Pass_Login
from Utilities.readProperties import ReadConfig
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


# First Scenario
@when('User Launches App Login Page')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('User should land on Correct Page')
def step_impl(context):
    applogin = AppLogin(context.driver)
    currenturl = context.driver.current_url
    if currenturl == ReadConfig.applogin_getappurl():
        assert True
    else:
        assert False


#################################################################################

# Second Scenario
@when('User is on App Login Page2')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Already have an account? Sign in" Text should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_text_already_have_account() == ReadConfig.applogin_getalreadyhaveaccount_text():
        assert True
    else:
        assert False


#################################################################################


# Third Scenario
@when('User is on App Login Page3')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Happy parkers make happy people" Text should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_text_happy_parkers() == ReadConfig.applogin_gethappyparkers_text():
        assert True
    else:
        assert False


#################################################################################


# Fourth Scenario
@when('User is on App Login Page4')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Sign in with Google" Button should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    isEnabled = applogin.fn_button_fn_sign_in_google()
    if isEnabled:
        assert True
    else:
        assert False


#################################################################################

# 5th Scenario

#################################################################################


# Sixth Scenario
@when('User is on App Login Page6')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Sign in with SSO Button should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    isEnabled = applogin.fn_button_fn_sign_in_sso()
    if isEnabled:
        assert True
    else:
        assert False


#################################################################################


# 7th Scenario
@when('User is on App Login Page7')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('or Text Should be visible after SSO login button')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_text_or() == ReadConfig.applogin_or_text():
        assert True
    else:
        assert False


#################################################################################

# 8th Scenario
@when('User is on App Login Page8')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Email Text Should be visible above Email Field box')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_text_email() == ReadConfig.applogin_email_text():
        assert True
    else:
        assert False


##################################################################################

# 9th Scenario
@when('User is on App Login Page9')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Email field should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    isEnabled = applogin.fn_email_field_visible()
    if isEnabled:
        assert True
    else:
        assert False


#######################################################################################

# 10th Scenario
@when('User is on App Login Page10')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Email placeholder you@example.com should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_email_placeholder_text() == ReadConfig.applogin_email_placeholder_text():
        assert True
    else:
        assert False


#################################################################################################

# 11th Scenario
@when('User is on App Login Page11')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Forget Password Link should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_forget_password_link_is_visible():
        assert True
    else:
        assert False


##########################################################################################

# 11th Scenario
@when('User is on App Login Page12')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Forget Password Link text should be Forgot Password?')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_forget_password_text() == ReadConfig.applogin_forgot_password_text():
        assert True
    else:
        assert False


##########################################################################################

# 12th Scenario
@when('User is on App Login Page13')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Password label should be Password')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_label_password() == ReadConfig.applogin_password_label():
        assert True
    else:
        assert False


##########################################################################################

# 13th Scenario
@when('User is on App Login Page14')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Check box should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_checkbox_is_visible():
        assert True
    else:
        assert False


##########################################################################################

# 14th Scenario
@when('Checkbox is clicked')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()
    applogin.fn_checkbox_is_clicked()


@then('Checkbox functionality should work')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_password_checkbox_type() == "text":
        assert True
    else:
        assert False


##########################################################################################

# 14th Scenario
@when('User is on App Login Page15')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('On Checkbox show password text should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_show_password_text_is_visible() == ReadConfig.applogin_show_password_text():
        assert True
    else:
        assert False


##########################################################################################

# 15th Scenario
# @when('User is on App Login Page16')
# def step_impl(context):
#     lg = Office_User_Pass_Login(context.driver)
#     applogin = AppLogin(context.driver)
#     context.driver.get(ReadConfig.applogin_getappurl())
#     wait = WebDriverWait(context.driver, 10)
#     element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
#     lg.accept_all_cookies()
#
#
# @then('Remember me radio button should be visible')
# def step_impl(context):
#     applogin = AppLogin(context.driver)
#     applogin.fn_rememberme_radiobutton_is_visible()


##########################################################################################

# 15th Scenario
@when('User is on App Login Page17')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Remember me text should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_rememberme_text_is_visible() == ReadConfig.applogin_rememberme_text():
        assert True
    else:
        assert False


##########################################################################################

# 16th Scenario
@when('User is on App Login Page18')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Sign in button should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_sign_in_button_is_visible():
        assert True
    else:
        assert False


##########################################################################################
# 17th Scenario
@when('User is on App Login Page19')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Didnt receive confirmation instructions?" button should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_didnt_received_confirmation_is_visible():
        assert True
    else:
        assert False

##########################################################################################

# 18th Scenario
@when('User is on App Login Page20')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()
    applogin.fn_didnt_received_confirmation_is_working()


@then('Didnt receive confirmation instructions?" button should be working')
def step_impl(context):
    applogin = AppLogin(context.driver)
    currenturl = context.driver.current_url
    if currenturl == ReadConfig.applogin_getdidntreceivedinstructionurl():
        assert True
    else:
        assert False


##########################################################################################
# 19th Scenario
@when('User is on App Login Page21')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()


@then('Didnt receive unlock instructions? button should be visible')
def step_impl(context):
    applogin = AppLogin(context.driver)
    if applogin.fn_didnt_received_unlock_instrcution_is_visible():
        assert True
    else:
        assert False


##########################################################################################
# 20th Scenario
@when('User is on App Login Page22')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    applogin = AppLogin(context.driver)
    context.driver.get(ReadConfig.applogin_getappurl())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()
    applogin.fn_didnt_received_unlock_is_working()


@then('Didnt receive unlock instructions? button should be working')
def step_impl(context):
    applogin = AppLogin(context.driver)
    currenturl = context.driver.current_url
    if currenturl == ReadConfig.applogin_getdidntreceivedunlockurl():
        assert True
    else:
        assert False


##########################################################################################
# Login Functionality
# First Scenario
@when('User Input Correct Credentials')
def step_impl(context):
    lg = Office_User_Pass_Login(context.driver)
    context.driver.get(ReadConfig.getCurrentURL())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    lg.accept_all_cookies()
    lg.input_user_email(ReadConfig.getUsername())
    lg.input_password(ReadConfig.getPassword())
    lg.click_login_button()
    time.sleep(10)


@then('User Logs in Successfully')
def step_impl(context):
    current_url = context.driver.current_url
    if current_url == ReadConfig.getCurrentURL():
        assert True
    else:
        assert False


# Second Scenario
@When("User Input Incorrect Username and Incorrect Password Credentials")
def step_impl(context):
    lg1 = Office_User_Pass_Login(context.driver)
    context.driver.get(ReadConfig.getApplicationURL())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    context.driver.find_element(By.ID, "lm-accept-all").click()
    lg1.input_user_email(ReadConfig.getWrongUsername())
    lg1.input_password(ReadConfig.getWrongPassword())
    lg1.click_login_button()


@then("User should get Login Error1")
def step_impl(context):
    lg2 = Office_User_Pass_Login(context.driver)
    error_message = lg2.login_error_msg_text()
    if error_message == ReadConfig.getloginerrormsg():
        assert True
    else:
        assert False


# Third Scenario
@When("User Input Correct Username and Incorrect Password Credentials")
def step_impl(context):
    lg3 = Office_User_Pass_Login(context.driver)
    context.driver.get(ReadConfig.getApplicationURL())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    context.driver.find_element(By.ID, "lm-accept-all").click()
    lg3.input_user_email(ReadConfig.getUsername())
    lg3.input_password(ReadConfig.getWrongPassword())
    lg3.click_login_button()


@then("User should get Login Error2")
def step_impl(context):
    lg4 = Office_User_Pass_Login(context.driver)
    error_message = lg4.login_error_msg_text()
    if error_message == ReadConfig.getloginerrormsg():
        assert True
    else:
        assert False


# Fourth Scenario
@When("User Input Incorrect Username and Incorrect Password")
def step_impl(context):
    lg5 = Office_User_Pass_Login(context.driver)
    context.driver.get(ReadConfig.getApplicationURL())
    wait = WebDriverWait(context.driver, 10)
    element = wait.until(EC.element_to_be_clickable((By.ID, 'lm-accept-all')))
    context.driver.find_element(By.ID, "lm-accept-all").click()
    lg5.input_user_email(ReadConfig.getWrongUsername())
    lg5.input_password(ReadConfig.getWrongPassword())
    lg5.click_login_button()


@then("User should get Login Error3")
def step_impl(context):
    lg6 = Office_User_Pass_Login(context.driver)
    error_message = lg6.login_error_msg_text()
    if error_message == ReadConfig.getloginerrormsg():
        assert True
    else:
        assert False
