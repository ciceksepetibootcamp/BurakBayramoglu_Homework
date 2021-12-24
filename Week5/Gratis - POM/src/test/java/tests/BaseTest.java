package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.net.MalformedURLException;

public class BaseTest {
    public AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = (AndroidDriver) Driver.InitializeDriver();
        PageFactory.initElements(driver, this);
    }

    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
