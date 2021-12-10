package all_tests;

import io.cucumber.java.After;
import org.openqa.selenium.Keys;
import sun.security.mscapi.CPublicKey;
import utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;

public class MonsterNotebookTests {
    WebDriver driver;
    @Given("User Navigates to G2A")
    public void navigateToWebsite(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.monsternotebook.com.tr/");
    }


    @FindBy(xpath = "//*[@id=\"validateLogin\"]/div/div")
    public WebElement loginbutton;

    @FindBy(xpath = "//div[@class='header-fix-btn-search']")
    public WebElement searchButton;

    @When("User should enter user information and try to login. {string} {string}")
    public void loginWithCorrectCredentials(String userName, String password){
        loginbutton.click(); //openpopup
        WebElement email = (WebElement) driver.findElement(By.xpath("//input[@attribute=\"mail\"]"));
        email.sendKeys(userName);
        WebElement passwordinput = (WebElement) driver.findElement(By.xpath("//input[@type=\"password\"]"));
        passwordinput.sendKeys(password);
        WebElement login = (WebElement) driver.findElement(By.xpath("//span[text()=\"GİRİŞ YAP\"]"));
        login.click();
    }

    @Then("User should see the new menu when clicks account button.")
    public void verifyLogin(){
        loginbutton.click(); //openpopup
        WebElement uyeligim = null;
        uyeligim = driver.findElement(By.xpath("//span[text()=\"Üyeliğim\"]"));
        loginbutton.click(); //closepopup
        if (uyeligim != null) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }



    @Then("User should not directed from sign-in form.")
    public void failedLogin(){
        WebElement signinbutton = (WebElement) driver.findElement(By.xpath("//span[text()=\"Giriş Yap\"]"));
        Assert.assertEquals("Giriş Yap", signinbutton.getText());
    }

    @And("User makes search. {string}")
    public void makeSearch(String itemname){
        searchButton.click();
        WebElement searchInputArea = (WebElement) driver.findElement(By.xpath("//input[@id='txtARM_KEYWORD']"));
        searchInputArea.click();
        searchInputArea.sendKeys(itemname);
        searchInputArea.sendKeys(Keys.ENTER);
    }

    @Then("User faces bad search page.")
    public void badSearch(){
        WebElement result = (WebElement)   driver.findElement(By.xpath("//span[text()='Aradığınız kriterlere']"));
        Assert.assertEquals("Aradığınız kriterlere", result.getText());
    }

    @Then("User adds first result to the basket.")
    public void goodSearch(){
        WebElement firstResult = (WebElement)   driver.findElement(By.xpath("//*[@id=\"ajxUrunList\"]/div/ul/li[1]/div/a"));
        firstResult.click();
        WebElement addToBasket = (WebElement) driver.findElement(By.xpath("//span[text()=\"SEPETE EKLE\"]"));
        addToBasket.click();
    }



    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }


}

