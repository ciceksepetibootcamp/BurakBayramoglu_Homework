package tests;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;

import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.Driver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class LoginTests {
    AndroidDriver driver;

    @Given("User Opens Gratis Application")
    public void openApp() throws MalformedURLException {
        driver = Driver.InitializeDriver();

        PageFactory.initElements(driver, this);
    }


    @When("User should enter user information and try to login. {string} {string}")
    public void login(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials(email, password);

    }

    @And("User should redirected to basket page and face a popup.")
    public void popup (){
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(loginPage.CLOSEPOPUP_BUTTON).click();
    }
    @Then("User should not redirected to basket page and should not face a popup.")
    public void failedlogin (){
        LoginPage loginPage = new LoginPage(driver);
        try {
            driver.findElement(loginPage.CLOSEPOPUP_BUTTON).click();
            assert  false;
        }
        catch(Exception e){
            assert true;
        }
    }

    @Then("User should see empty basket message. {string}")
    public void succesfulLoginAssertion (String actualText){
        String expectedText= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText(); // Assertion element
        Assert.assertEquals(actualText, expectedText);
    }

    @After
    public void quitDriver(){
        Driver.quitDriver();
    }

}
