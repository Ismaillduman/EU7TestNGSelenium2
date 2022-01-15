package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.switchTo().frame("mce_0_ifr");//iceri gir
        Thread.sleep(2000);
driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("tinymce")).sendKeys(" mike smith");

        driver.switchTo().defaultContent();//geri cik

        //2. switching  with INDEX
        driver.switchTo().frame(0); //iceri gir
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("tinymce")).sendKeys(" mike smith with INDEX ");

        //secod way to switch parent
        driver.switchTo().parentFrame();//geri cik
        //3 USING  WEBELEMENT

        WebElement iframeElement= driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).sendKeys(" mike smith withWEBELEMENT");



    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/nested_frames");


        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
