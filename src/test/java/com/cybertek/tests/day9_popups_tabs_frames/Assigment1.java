package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assigment1 {

    //   (//*[.='Registration Form'])[2]
    //   //input[@*='MM/DD/YYYY']

    WebDriver driver;
    @BeforeMethod
    public void  setup() {
        driver = WebDriverFactory.getDriver("chrome");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//(implicity)
    }
    @AfterMethod
    public void closePage(){
        //driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

       driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();
       driver.findElement(By.xpath("//input[@*='MM/DD/YYYY']")).sendKeys("wrong_dob");
       WebElement invalidText = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        System.out.println("warning "+invalidText.getAttribute("innerHTML"));





    }
}
