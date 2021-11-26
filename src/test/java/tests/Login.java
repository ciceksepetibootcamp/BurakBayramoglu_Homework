package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver;

    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/bbayr/Desktop/Python/UT21 NEW UI/driver/96/chromedriver.exe"); // Kullanılacak driver path'ını belirt
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.ciceksepeti.com/uye-girisi");
        driver.manage().window().maximize(); // Tarayıcıyı tam ekran yap
        js = (JavascriptExecutor) driver;

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginCredentialsFailure() throws InterruptedException {

        driver.findElement(By.cssSelector("#EmailLogin")).sendKeys("qqqq@hotmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#userLogin > div.form-group.form-user-login__action > button")).click();

        String loginResult = driver.findElement(By.cssSelector("#modalBox > div > div > div.modal-body")).getAttribute("textContent");
        String expectedResult = "Mail adresi veya şifre hatalı.Lütfen bilgilerinizi kontrol edip tekrar deneyin.";
        Assert.assertEquals(expectedResult, loginResult); // Karşılaştırma işlemini gerçekleştir.
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#modalBox > div > div > div.modal-footer > button")).click(); // Gelen hata popupunu onayla.

    }

    @Test
    public void loginSuccess() throws InterruptedException {

        driver.findElement(By.cssSelector("#EmailLogin")).sendKeys("editme@hotmail.com"); // Geçerli bir e-posta ile düzenlenmesi gerekmektedir.
        driver.findElement(By.cssSelector("#Password")).sendKeys("editme"); // Geçerli bir şifre ile düzenlenmesi gerekmektedir.
        driver.findElement(By.cssSelector("#userLogin > div.form-group.form-user-login__action > button")).click();

        driver.findElement(By.xpath("//span[@class='icon-close']")).click(); // Popup kapatma, başarılı giriş durumunda bu pop-up ile karşılaşılması gerekiyor. Eğer başarısız giriş yapılmış ise kodumuz burada fail olacaktır.
        Thread.sleep(2000);

    }


}
