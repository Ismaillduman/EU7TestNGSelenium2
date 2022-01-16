package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       // WebElement Button1=driver.findElement(By.xpath("//*[@onclick='button1()']"));
//Button1.click();
driver.findElement(By.xpath("//*[@name=\"button2\"]")).click();
    }

}
