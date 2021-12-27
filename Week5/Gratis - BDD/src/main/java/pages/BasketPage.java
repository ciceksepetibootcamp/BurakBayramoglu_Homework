package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.*;

public class BasketPage {
    public AndroidDriver<MobileElement> driver;
    public static final By BASKET_BUTTON = By.id("com.gratis.android:id/badgeView");
    public static final By ITEMS_NUMBER_AT_BASKET = By.id("com.gratis.android:id/shopping_item_number_txt");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("com.gratis.android:id/empty_view_btn");
    public static final By REMOVE_FROM_BASKET_BUTTON = By.id("com.gratis.android:id/shopping_item_delete_btn");
    public static final By ACCEPT_ITEM_REMOVAL_BUTTON = By.id("android:id/button1");


    public static final By CLOSEPOPUP_BUTTON = By.id("com.gratis.android:id/close_btn");

    public BasketPage(AndroidDriver driver) {

        this.driver = driver;
    }

    public String itemAmountAtBasket(){

        driver.findElement(BASKET_BUTTON).click();
        return driver.findElement(ITEMS_NUMBER_AT_BASKET).getText();
    }

    public void closeBasketPopup()
    {
        driver.findElement(CLOSEPOPUP_BUTTON).click();
    }

    public void removeItemFromBasket()
    {
        driver.findElement(BASKET_BUTTON).click();
        closeBasketPopup();
        driver.findElement(REMOVE_FROM_BASKET_BUTTON).click();
        driver.findElement(ACCEPT_ITEM_REMOVAL_BUTTON).click();
    }
}