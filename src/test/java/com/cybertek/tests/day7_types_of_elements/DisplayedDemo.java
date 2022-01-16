package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput= driver.findElement(By.id("username"));

        //System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        Assert.assertFalse(userNameInput.isDisplayed(),"verify username inputbox is not displayed on the screen");
        //WebElement startButton=driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        WebElement startButton=driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(6000);
        Assert.assertTrue(userNameInput.isDisplayed(),"verify username is displayed on the screen");

driver.quit();





    }
}
