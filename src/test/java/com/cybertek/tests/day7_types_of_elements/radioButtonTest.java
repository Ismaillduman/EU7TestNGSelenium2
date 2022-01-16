package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class radioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn= driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn= driver.findElement(By.id("red"));


//how to check radio button is selected
        System.out.println("blueRadioBtn.is selected()= "+blueRadioBtn.isSelected());
        System.out.println("redRadioBtn. is selected()="+redRadioBtn.isSelected());

        //verify blue is selected red is not selected
        //blue
        //red
        Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that red is not selected");


        //how to cliCk radio button?
        redRadioBtn.click();





        Assert.assertFalse(blueRadioBtn.isSelected(),"verify that blue is NOT selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"verify that red is selected");

        Thread.sleep(3000);
        driver.quit();











    }
}
