from datetime import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from Pages.homepage import HomePage
from Pages.basketpage import BasketPage
import time
class Tests():



    @pytest.fixture()
    def test_setup(self):
        global driver
        driver = webdriver.Chrome(executable_path="C:\Drivers\chromedriver.exe")
        driver.implicitly_wait(8)
        driver.get("https://thebouqet.com/")
        driver.maximize_window()

        yield
        driver.close()
        driver.quit()

    def test_succes_add_items(self, test_setup):
        home_page = HomePage(driver)
        additems = 2
        for x in range(1, additems + 1):

            home_page.add_item_to_basket(x)
            time.sleep(3)
            home_page.goto_homepage()

        itemnumberatbasket = home_page.get_item_number_at_basket()

        if itemnumberatbasket == additems:
            assert True
        else:
            assert False

    def test_empty_basket(self, test_setup):
        #fill basket with some random items
        home_page = HomePage(driver)
        additems = 1
        for x in range(1, additems + 1):

            home_page.add_item_to_basket(x)
            time.sleep(3)
            home_page.goto_homepage()



        basket_page = BasketPage(driver)
        #basket_page.scroll_to_top()
        basket_page.goto_basket()

        atbasket = 50
        while atbasket != 0:
            basket_page.remove_from_basket()
            time.sleep(2)
            atbasket = basket_page.check_item_number_at_basket()


        text = driver.find_element_by_xpath("//div[@id='EmptyCart']/p[1]").get_attribute("textContent")
        assert text == "Sepetinizde hiç ürün yok !"

    def test_change_quantity(self, test_setup):

        #add an item to basket
        home_page = HomePage(driver)
        home_page.add_item_to_basket(1)
        time.sleep(3)
        home_page.goto_homepage()

        newitemamouth = 5
        basket_page = BasketPage(driver)
        basket_page.goto_basket()
        per_item_price = basket_page.per_item_price()

        quantity_element = basket_page.item_quantity_in_basket_element()
        quantity_element.clear()
        quantity_element.send_keys(newitemamouth)
        basket_page.refresh_basket()

        totalbasketcost = driver.find_element_by_xpath("//span[@class='cart__subtotal h3']").get_attribute(
            "textContent").replace("TL", "")
        if float(per_item_price) * newitemamouth == float(totalbasketcost):
            assert True

