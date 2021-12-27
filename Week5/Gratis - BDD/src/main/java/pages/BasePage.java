package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.*;

public class BasePage {
    public AndroidDriver<MobileElement> driver;
    public static final By BASKET_BUTTON = By.id("com.gratis.android:id/badgeView");
    public static final By MAINPAGE_BUTTON = By.xpath("//android.widget.FrameLayout[@content-desc=\"Anasayfa\"]");
    public static final By SEARCH_BUTTON = By.id("com.gratis.android:id/main_page_search_text");
    public static final By SEARCH_INPUT = By.id("com.gratis.android:id/search_src_text");


    public BasePage (AndroidDriver driver){

        this.driver = driver;
    }

    public void search(String itemName) {
        Helpers.waitAndClick(driver, SEARCH_BUTTON);
        driver.findElement(SEARCH_INPUT).click();
        driver.findElement(SEARCH_INPUT).sendKeys(itemName);
        Helpers.pressEnter(driver);
    }

    public void addItemToBasket(String itemIndex ) throws InterruptedException {
        MobileElement dynamicElementByXPath = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout["+ itemIndex + "]");
        dynamicElementByXPath.click();
        Helpers.scrollAndClick("SEPETE EKLE",driver);
    }


}