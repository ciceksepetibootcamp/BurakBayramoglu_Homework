package tests;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;
import utils.Driver;

import java.net.MalformedURLException;


public class BasketTests{


    AndroidDriver driver;
    @Before
    public void driver() throws MalformedURLException {
        driver = Driver.InitializeDriver();
    }



    @And("User should make search. {string}")
    public void search (String itemtosearch) {
        BasePage basePage = new BasePage(driver);
        BasketPage basketPage = new BasketPage(driver);
        driver.findElement(basketPage.CONTINUE_SHOPPING_BUTTON).click();
        basePage.search(itemtosearch);
    }

    @And("User should add an item to the basket.")
    public void results () throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.addItemToBasket("1");
    }

    @Then("User should see one item at the basket.")
    public void assertion () throws InterruptedException {
        BasketPage basketPage = new BasketPage(driver);
        Assert.assertEquals("1", basketPage.itemAmountAtBasket());
    }

    @And("User should remove item from basket.")
    public void removeItem () throws InterruptedException {
        BasketPage basketPage = new BasketPage(driver);
        basketPage.removeItemFromBasket();
    }

}