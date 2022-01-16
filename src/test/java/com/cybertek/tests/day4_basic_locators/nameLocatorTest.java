package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement FullNameInput= driver.findElement(By.name("full_name"));
        FullNameInput.sendKeys("ismail Dustman");

        //WebElement emailInputBox= driver.findElement(By.name("email"));
        //emailInputBox.sendKeys("ismailduman@web/de");
        driver.findElement(By.name("email")).sendKeys("ismailduman@gmail.com");


        //WebElement singUpButton= driver.findElement(By.name("wooden_spoon"));
        //singUpButton.click();

        driver.findElement(By.name("wooden_spoon")).click();
    }
}
