using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Interactions;
using NUnit.Framework;
using dotNET_Test.TestClasses;
using SeleniumExtras.PageObjects;

namespace dotNET_Test.PageObjects {

public class BasketPage :   BasePage {

    public BasketPage (IWebDriver driver) {
        BasketPage.driver = driver;
        PageFactory.InitElements(driver,this);
      }
    public void remove_from_basket()
    {
        driver.FindElement(By.CssSelector("tbody > tr:nth-of-type(1) .cart__remove")).Click();
    }
    
    public String check_item_number_at_basket()
    {
        return driver.FindElement(By.XPath("//*[@id='CartCount']")).GetAttribute("textContent");
    }

    public void change_item_quantity(String newQuantity)
    {
        IWebElement quantity = driver.FindElement(By.XPath("//input[@name='updates[]']"));
        quantity.Clear();
        quantity.SendKeys(newQuantity);
        refresh_basket();

    }

    public void refresh_basket()
    {
        driver.FindElement(By.XPath("//button[@name='update']")).Click();
    }

}
}   