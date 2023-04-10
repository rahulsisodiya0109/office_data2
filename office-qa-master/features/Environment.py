from selenium import webdriver
from selenium.webdriver.chrome.service import Service
import sys


def before_scenario(context, scenario):
    print("Driver Executed")
    print(sys.setrecursionlimit(2000))
    context.driver = webdriver.Chrome(
        service=Service("/Drivers\\chromedriver.exe"))
    context.driver.maximize_window()


def after_scenario(context, scenario):
    print("Driver Closed")
    context.driver.close()
