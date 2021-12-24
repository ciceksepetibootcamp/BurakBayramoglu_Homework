package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;


public class BasketTests extends  BaseTest {

    @Test
    public void AddToBasketTest() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.addItemToBasket("Ruj","1");
        Assert.assertEquals("1", basePage.itemAmountAtBasket());
    }
}
