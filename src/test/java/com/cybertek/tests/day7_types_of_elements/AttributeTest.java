package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
       /* driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn= driver.findElement(By.id("blue"));
        System.out.println(blueRadioBtn.getAttribute("value"));
        System.out.println(blueRadioBtn.getAttribute("type"));
        System.out.println(blueRadioBtn.getAttribute("name"));
        System.out.println(blueRadioBtn.getAttribute("checked"));
        System.out.println(blueRadioBtn.getAttribute("href"));
        String outerHTML= blueRadioBtn.getAttribute("outerHTML");
        System.out.println(outerHTML);
       // Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println(blueRadioBtn.getAttribute("innerHTML"));   */


driver.get("http://practice.cybertekschool.com/multiple_buttons");

WebElement button2=driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
       String outerHTML1= button2.getAttribute("outerHTML");
       Assert.assertTrue(outerHTML1.contains("Button 2"));
        System.out.println("InnerHTML: "+button2.getAttribute("innerHTML"));





Thread.sleep(3000);
        driver.quit();


    }
}
