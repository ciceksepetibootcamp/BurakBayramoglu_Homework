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
public class TestClass1 {
    private WebDriver driver;

    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/bbayr/Desktop/Python/UT21 NEW UI/driver/96/chromedriver.exe"); // Kullanılacak driver path'ını belirt
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ciceksepeti.com/bluetooth-kulaklik");
        driver.manage().window().maximize(); // Tarayıcıyı tam ekran yap
        driver.findElement(By.xpath("//span[@class='icon-close']")).click(); // Popup kapatma
        js = (JavascriptExecutor) driver;

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addRandomItemToBasket() throws InterruptedException {


        String randomItemCss = String.format("body > main > div > div.products.products--category.js-ajax-category-products > div:nth-child(%s) > div > div > a",1 + (int)(Math.random() * ((5 - 1) + 1))); // Rastgele ürün için Css Selector formatlama
        driver.findElement(By.cssSelector(randomItemCss)).click(); // Rastgele ürün seç
        Thread.sleep(3000);
        String itemName = driver.findElement(By.cssSelector("div.product__info-wrapper > div > div.product__info-wrapper--left > h1 > span")).getAttribute("textContent"); // Görüntülenen ürün ismini  kontrol etmek üzere kaydet
        driver.findElement(By.cssSelector("#productDetailSend > div > div > div:nth-child(2) > div.product__main-info-right.js-set-date-base-campaing-class > div.js-advertisement-available > div.product__action > div.product__action-col > button")).click(); // Sepete ekleme butonuna bas
        Thread.sleep(3000);
        String actualItemAtBasked = driver.findElement(By.cssSelector("div.cart__item.cart__item--has-extras > div > h3 > a")).getAttribute("textContent"); // Sepetteki ürün ismini  kontrol etmek üzere kaydet
        Assert.assertEquals(itemName, actualItemAtBasked.trim()); // Karşılaştırma işlemini gerçekleştir.
    }

    @Test
    public void addRoseToBasketFailure() throws InterruptedException {
        driver.get("https://www.ciceksepeti.com/guller");
        driver.findElement(By.cssSelector("body > main > div > div.products.products--category.js-ajax-category-products > div:nth-child(1)")).click(); // İlk sonucu seçme
        driver.findElement(By.cssSelector("#productDetailSend > div > div > div:nth-child(2) > div.product__main-info-right.js-set-date-base-campaing-class > div.js-advertisement-available > div.product__action > div.product__action-col > button")).click(); // Sipariş ver butonuna tıkla
        String ActualText = driver.findElement(By.cssSelector("#productDetailSend > div > div > div:nth-child(2) > div.product__main-info-right.js-set-date-base-campaing-class > div.js-advertisement-available > div.product__error.js-product-error--location.is-hidden > p")).getAttribute("textContent"); // Karşılaştırmak üzere alınan hatayı değişkene kaydet
        String ExpectedText = "Adresin tamamını girmek yerine sadece mahalle veya sokak, hastane, okul ismi gibi bilgiyi girin.";
        Assert.assertEquals(ActualText, ExpectedText); // Karşılaştırma işlemini gerçekleştir.
        Thread.sleep(3000);
    }
}

