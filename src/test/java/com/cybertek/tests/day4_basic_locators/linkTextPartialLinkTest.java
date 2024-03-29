package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextPartialLinkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement textLink=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
//textLink.click();
driver.findElement(By.partialLinkText("Example 4")).click();
Thread.sleep(3000);
driver.quit();
    }
}
