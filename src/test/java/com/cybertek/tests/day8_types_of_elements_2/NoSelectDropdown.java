package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
// 1. locate your dropDown just like any other webelement with unique locator

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));
        //2. create Select object by passing that element as a constructor
        // Select stateDropDown = new Select(dropDownElement);

        dropDownElement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5, "verify the expected size");
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }

dropdownOptions.get(2).click();
    }
}





















