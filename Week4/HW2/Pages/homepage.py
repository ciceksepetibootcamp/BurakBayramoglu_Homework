import time

class HomePage():
    def __init__(self, driver):
        self.driver = driver

        self.scroll_to_top = self.driver.execute_script("scroll(0, 0);")
        self.basket_button = self.driver.find_element_by_xpath("//span[@class='small--hide']")


    def goto_homepage(self):
        self.driver.get("https://thebouqet.com/")

    def add_item_to_basket(self, index):
        self.driver.find_element_by_xpath(f'//*[@id="shopify-section-featured-products"]/div/div/div[{index}]').click()
        self.driver.find_element_by_xpath("//span[@id='AddToCartText']").click()


    def get_item_number_at_basket(self):
        return int(self.driver.find_element_by_xpath('//*[@id="CartCount"]').get_attribute("textContent"))