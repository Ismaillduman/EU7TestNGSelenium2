package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    @BeforeMethod
    public void  setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//(implicity)
    }
        @AfterMethod
                public void closePage(){
           driver.quit();
        }
        @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");



        driver.findElement(By.tagName("Button")).click();

        WebElement userNameInput= driver.findElement(By.cssSelector("#username"));

        //create the explicit wait object

            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(userNameInput));
            userNameInput.sendKeys("Mikes Smith");

        }

        @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("//*[.='Enable']")).click();

        WebElement inputBox= driver.findElement(By.cssSelector("#input-example>input"));
            WebDriverWait wait= new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.elementToBeClickable(inputBox));


        inputBox.sendKeys("Mike Smith");

        Thread.sleep(2000);






        }


}
