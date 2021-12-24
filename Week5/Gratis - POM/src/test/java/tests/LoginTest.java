package tests;


import org.junit.Assert;
import org.junit.Test;
import pages.*;


public class LoginTest extends  BaseTest {




    @Test
    public void LoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("burakbtestdata@yandex.com","147258369Bb.");
        String expectedText= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText(); // Assertion element
        Assert.assertEquals("Sepetin şu an boş", expectedText);
    }



}
