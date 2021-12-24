package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.*;

public class BasePage {
    public AndroidDriver<MobileElement> driver;
    public static final By BASKET_BUTTON = By.id("com.gratis.android:id/badgeView");
    public static final By MAINPAGE_BUTTON = By.id("com.gratis.android:id/menu_main_page");
    public static final By SEARCH_BUTTON = By.id("com.gratis.android:id/main_page_search_text");
    public static final By SEARCH_INPUT = By.id("com.gratis.android:id/search_src_text");
    public static final By ITEMS_NUMBER_AT_BASKET = By.id("com.gratis.android:id/shopping_item_number_txt");

    public BasePage (AndroidDriver driver){

        this.driver = driver;
    }


    public void addItemToBasket(String itemName, String itemIndex ) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("burakbtestdata@yandex.com","147258369Bb.");
        driver.findElement(MAINPAGE_BUTTON).click();
        utils.waitAndClick(driver, SEARCH_BUTTON);
        driver.findElement(SEARCH_INPUT).click();
        driver.findElement(SEARCH_INPUT).sendKeys(itemName);
        utils.pressEnter(driver);
        MobileElement dynamicElementByXPath = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout["+ itemIndex + "]");
        dynamicElementByXPath.click();
        utils.scrollAndClick("SEPETE EKLE",driver);
    }

    public String itemAmountAtBasket(){

        driver.findElement(BASKET_BUTTON).click();
        return driver.findElement(ITEMS_NUMBER_AT_BASKET).getText();

    }
}
