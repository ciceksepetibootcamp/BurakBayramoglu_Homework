package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils{
    public AndroidDriver<MobileElement> driver;
    public utils (AndroidDriver driver){
        this.driver = driver;
    }
    public static void scrollAndClick(String visibleText, AndroidDriver driver) {

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    public static void pressEnter(AndroidDriver driver)
    {
        driver.getKeyboard().pressKey(Keys.ENTER);
    }

    public static void waitAndClick(AndroidDriver driver, By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}

