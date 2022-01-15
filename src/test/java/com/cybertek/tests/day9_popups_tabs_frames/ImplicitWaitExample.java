package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void close() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //Thread.sleep(2000);

        WebElement element= driver.findElement(By.cssSelector("#finish"));
        System.out.println(element.getText());
       //driver.manage().timeouts.implicitWait(10, TimeUnit.seconds )
/*İmplicit wait  tüm objelere uygulanır ve belirtilen süre içerisinde
 bu objeyi aramaya devam eder, bulunmasını istediğimiz obje için
ExpectedConditions belitmek zorunda değiliz.*/
        /*Explicit wait ise bizim erişmek istediğimiz öğeye uygulanır.
   Belirli obje  ve koşul gereklidir.
   Bulunmasını istediğimiz obje için ExpectedConditions belitmeliyiz

 */

        /*WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        WebElement searchElement = (new WebDriverWait(driver,
10)).until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        */
    }

}
