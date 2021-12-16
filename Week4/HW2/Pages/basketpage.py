import time


class BasketPage():
    def __init__(self, driver):
        self.driver = driver

        self.scroll_to_top = self.driver.execute_script("scroll(0, 0);")
        self.basket_button = self.driver.find_element_by_xpath("//span[@class='small--hide']")



    def goto_basket(self):
        time.sleep(2)

        self.basket_button.click()

    def remove_from_basket(self):
        self.driver.find_element_by_css_selector("tbody > tr:nth-of-type(1) .cart__remove").click()

    def check_item_number_at_basket(self):
        return int(self.driver.find_element_by_xpath('//*[@id="CartCount"]').get_attribute("textContent"))

    def item_quantity_in_basket_element(self):
        return self.driver.find_element_by_xpath("//input[@name='updates[]']")

    def per_item_price(self):
        return self.driver.find_element_by_xpath("//*[@id='MainContent']/div[1]/div/form/table/tbody/tr/td[3]").get_attribute("textContent").replace("\n","").replace("TL","")

    def refresh_basket(self):
        self.refresh_button = self.driver.find_element_by_xpath("//button[@name='update']")
        self.refresh_button.click()
