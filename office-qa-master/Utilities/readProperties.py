import configparser

config = configparser.RawConfigParser()
config.read(".\\Configuration\\config.ini")


class ReadConfig:
    @staticmethod
    def getApplicationURL():
        baseurl = config.get('Common info', 'baseURL')
        return baseurl

    @staticmethod
    def getCurrentURL():
        currenturl = config.get('Common info', 'currentURL')
        return currenturl

    @staticmethod
    def getUsername():
        username = config.get('User Details', 'username1')
        return username

    @staticmethod
    def getWrongUsername():
        wrongusername = config.get('User Details', 'wrongusername1')
        return wrongusername

    @staticmethod
    def getPassword():
        password = config.get('User Details', 'password1')
        return password

    @staticmethod
    def getWrongPassword():
        wrongpassword = config.get('User Details', 'wrongpassword')
        return wrongpassword

    @staticmethod
    def getloginerrormsg():
        loginerrormsg = config.get('ErrorMessage', 'loginerror')
        return loginerrormsg

    @staticmethod
    def getloginerrormsg():
        loginerrormsg = config.get('ErrorMessage', 'loginerror')
        return loginerrormsg

    @staticmethod
    def getAccountSettingsURL():
        accsetturl = config.get('AccountSettings', 'baseurl')
        return accsetturl

    @staticmethod
    def getAccountSettingsText():
        accsetttext = config.get('AccountSettings', 'accountsettings_text')
        return accsetttext

    @staticmethod
    def getGeneralTabText():
        generaltabtext = config.get('AccountSettings', 'general_tab_text')
        return generaltabtext

    @staticmethod
    def getVehicleTabText():
        vehiclestabtext = config.get('AccountSettings', 'vehicles_tab_text')
        return vehiclestabtext

    @staticmethod
    def getNotificationsTabText():
        Notificationstabtext = config.get('AccountSettings', 'notifications_tab_text')
        return Notificationstabtext

    @staticmethod
    def getPasswordTabText():
        Passwordtabtext = config.get('AccountSettings', 'password_tab_text')
        return Passwordtabtext



    ####################################################################################
    # App Login Page Details

    @staticmethod
    def applogin_getappurl():
        appurl = config.get('AppLogin', 'applogin_url')
        return appurl

    @staticmethod
    def applogin_getalreadyhaveaccount_text():
        alreadyhaveaccounttext = config.get('AppLogin', 'alreadyaccount_text')
        return alreadyhaveaccounttext

    @staticmethod
    def applogin_gethappyparkers_text():
        happyparkersttext = config.get('AppLogin', 'happyparkers_text')
        return happyparkersttext

    @staticmethod
    def applogin_or_text():
        ortext = config.get('AppLogin', 'or')
        return ortext

    @staticmethod
    def applogin_email_text():
        emailtext = config.get('AppLogin', 'email')
        return emailtext

    @staticmethod
    def applogin_email_placeholder_text():
        emailplaceholdertext = config.get('AppLogin', 'email_placeholder_text')
        return emailplaceholdertext

    @staticmethod
    def applogin_forgot_password_text():
        forgotpasswordtext = config.get('AppLogin', 'forgotpassword_text')
        return forgotpasswordtext

    @staticmethod
    def applogin_password_label():
        passwordlabel = config.get('AppLogin', 'passwordlabel')
        return passwordlabel

    @staticmethod
    def applogin_show_password_text():
        showpasaswordtext = config.get('AppLogin', 'showpassword')
        return showpasaswordtext

    @staticmethod
    def applogin_rememberme_text():
        remembermetext = config.get('AppLogin', 'remember_me')
        return remembermetext

    @staticmethod
    def applogin_getdidntreceivedinstructionurl():
        didntreceivedinstructionurl = config.get('AppLogin', 'didnt_recevied_instruction_url')
        return didntreceivedinstructionurl

    @staticmethod
    def applogin_getdidntreceivedunlockurl():
        didntreceivedunlockurl = config.get('AppLogin', 'didnt_received_unlock_url')
        return didntreceivedunlockurl
