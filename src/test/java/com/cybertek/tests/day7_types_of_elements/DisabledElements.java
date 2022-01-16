package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadiBtn= driver.findElement(By.id("green"));

        //how to cheeck any webelement is enabled or not

        System.out.println("greenRadiBtn.isEnabled() = " + greenRadiBtn.isEnabled());
        Assert.assertFalse(greenRadiBtn.isEnabled(),"verify green radio button not enabled");
       greenRadiBtn.click();
        /*WebElement greenRadioBtn = driver.findElement(By.id("green"));

        //how to check any web element is enabled or not ?
        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled(),"verify green radio button NOT enabled (disabled)");

        greenRadioBtn.click();*/
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputTextSearchBtn= driver.findElement(By.xpath("//input[@type='text']"));
        //WebElement inputTextSearchBtn= driver.findElement(By.xpath("#input-example>input"));

inputTextSearchBtn.sendKeys("some message");


    }
}