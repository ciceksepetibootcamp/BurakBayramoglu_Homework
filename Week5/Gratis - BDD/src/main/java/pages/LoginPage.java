package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{


    public static final By EMAIL_INPUT = By.id("com.gratis.android:id/email_et");
    public static final By PASSWORD_INPUT = By.id("com.gratis.android:id/password_et");
    public static final By LOGIN_BUTTON = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.Button[1]");
    public static final By CLOSEPOPUP_BUTTON = By.id("com.gratis.android:id/close_btn");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void loginWithCredentials(String email, String password)
    {
        driver.findElement(BASKET_BUTTON).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}