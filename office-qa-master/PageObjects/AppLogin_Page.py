from selenium.webdriver.common.by import By


class AppLogin:
    text_already_have_account = "/html/body/div[1]/div/div/h1"
    text_happy_parkers = "/html/body/div[1]/div/div/p"
    button_sign_in_with_google = "/html/body/div[1]/div/div/a[1]"
    button_sign_in_with_sso = "/html/body/div[1]/div/div/a[2]"
    text_or = "/html/body/div[1]/div/div/span/span"
    label_email = "/html/body/div[1]/div/div/form/div[1]/label"
    id_email_field = "user_email"
    forget_password_link_xpath = "/html/body/div[1]/div/div/form/div[2]/div[1]/div[2]/a"
    label_password = "/html/body/div[1]/div/div/form/div[2]/div[1]/div[1]/label"
    check_box_id = "show_password"
    password_field_id = "user_password"
    forget_password_link_text = "Forgot password?"
    show_password_text_xpath = "/html/body/div[1]/div/div/form/div[3]/div/div/span"
    remember_me_id = "user_remember_me"
    remember_me_text_xpath = "//label[normalize-space()='Remember me']"
    sign_in_button_name = "commit"
    didnt_received_confirmation_button_xapth = "//a[@href='/users/confirmation/new']"
    didnt_received_unlock_instruction_button_xapth = "//a[@href='/users/unlock/new']"

    def __init__(self, driver):
        self.driver = driver

    def fn_text_already_have_account(self):
        return self.driver.find_element(By.XPATH, self.text_already_have_account).text

    def fn_text_happy_parkers(self):
        return self.driver.find_element(By.XPATH, self.text_happy_parkers).text

    def fn_button_fn_sign_in_google(self):
        return self.driver.find_element(By.XPATH, self.button_sign_in_with_google).is_enabled()

    def fn_button_fn_sign_in_sso(self):
        return self.driver.find_element(By.XPATH, self.button_sign_in_with_sso).is_enabled()

    def fn_text_or(self):
        return self.driver.find_element(By.XPATH, self.text_or).text

    def fn_text_email(self):
        return self.driver.find_element(By.XPATH, self.label_email).text

    def fn_email_field_visible(self):
        return self.driver.find_element(By.ID, self.id_email_field).is_enabled()

    def fn_email_placeholder_text(self):
        return self.driver.find_element(By.ID, self.id_email_field).get_attribute("placeholder")

    def fn_forget_password_link(self):
        return self.driver.find_element(By.XPATH, self.forget_password_link_xpath).size()

    def fn_forget_password_text(self):
        return self.driver.find_element(By.XPATH, self.forget_password_link_xpath).text

    def fn_label_password(self):
        return self.driver.find_element(By.XPATH, self.label_password).text

    def fn_checkbox_is_visible(self):
        return self.driver.find_element(By.ID, self.check_box_id).is_enabled()

    def fn_checkbox_is_clicked(self):
        self.driver.find_element(By.ID, self.check_box_id).click()

    def fn_password_checkbox_type(self):
        return self.driver.find_element(By.ID, self. password_field_id).get_attribute("type")

    def fn_forget_password_link_is_visible(self):
        return self.driver.find_element(By.LINK_TEXT, self. forget_password_link_text).is_enabled()

    def fn_show_password_text_is_visible(self):
        return self.driver.find_element(By.XPATH, self. show_password_text_xpath).text

    def fn_rememberme_radiobutton_is_visible(self):
        button = self.driver.find_element(By.ID, "remember_me_id")
        self.driver.execute_script("arguments[0].click();", button)

    def fn_rememberme_text_is_visible(self):
        return self.driver.find_element(By.XPATH, self. remember_me_text_xpath).text

    def fn_sign_in_button_is_visible(self):
        return self.driver.find_element(By.NAME, self. sign_in_button_name).is_enabled()

    def fn_didnt_received_confirmation_is_visible(self):
        return self.driver.find_element(By.XPATH, self. didnt_received_confirmation_button_xapth).is_enabled()

    def fn_didnt_received_confirmation_is_working(self):
        self.driver.find_element(By.XPATH, self. didnt_received_confirmation_button_xapth).click()

    def fn_didnt_received_unlock_instrcution_is_visible(self):
        return self.driver.find_element(By.XPATH, self. didnt_received_unlock_instruction_button_xapth).is_enabled()

    def fn_didnt_received_unlock_is_working(self):
        self.driver.find_element(By.XPATH, self.didnt_received_unlock_instruction_button_xapth).click()


class Office_User_Pass_Login:

    button_accept_cookies_id = "lm-accept-all"
    button_user_email_id = "user_email"
    button_user_password_id = "user_password"
    button_click_name = "commit"
    error_msg_xpath = "//p[@class='m-0 alert_alert']"

    def __init__(self, driver):
        self.driver = driver

    def accept_all_cookies(self):
        self.driver.find_element(By.ID, self.button_accept_cookies_id).click()

    def input_user_email(self, Username):
        self.driver.find_element(By.ID, self.button_user_email_id).send_keys(Username)

    def input_password(self, Password):
        self.driver.find_element(By.ID, self.button_user_password_id).send_keys(Password)

    def click_login_button(self):
        self.driver.find_element(By.NAME, self.button_click_name).click()

    def login_error_msg_text(self):
        return self.driver.find_element(By.XPATH, self.error_msg_xpath).text




