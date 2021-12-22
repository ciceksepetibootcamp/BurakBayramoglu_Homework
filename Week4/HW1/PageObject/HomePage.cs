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
using SeleniumExtras.PageObjects;
using dotNET_Test.TestClasses;

namespace dotNET_Test.PageObjects {

  public class HomePage : BasePage {
      public HomePage (IWebDriver driver) {
        HomePage.driver = driver;
        PageFactory.InitElements(driver,this);
      }

    public void addToBasket(){
        driver.FindElement(By.XPath("//*[@id='shopify-section-featured-products']/div/div/div[1]")).Click();
        driver.FindElement(By.XPath("//span[@id='AddToCartText']")).Click();
    }

    public void goToBasket(){
      driver.FindElement(By.XPath("//span[@class='small--hide']")).Click();
    }

  }
}