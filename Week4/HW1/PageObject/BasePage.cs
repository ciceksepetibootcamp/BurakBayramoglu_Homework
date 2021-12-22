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

namespace dotNET_Test.TestClasses {

  public class BasePage{
    public static IWebDriver driver;

    public void Initialize() {
      driver = new ChromeDriver("C:/Drivers");
      driver.Manage().Window.Maximize();
      WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(8));
      driver.Url = "https://thebouqet.com/";
    }


    public void TearDown() {
        driver.Quit();
      }
  }
}