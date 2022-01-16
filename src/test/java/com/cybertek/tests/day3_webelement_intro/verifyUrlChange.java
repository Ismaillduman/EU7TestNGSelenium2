package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChange {
    public static void main(String[] args) throws InterruptedException {
         /*Verify URL changed
        -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password Links to an ext
        entry anymail
        -click on Retrieve password
        -verify that url change to http://practice.cybertekschool.com/email_send
    */  //OPEN BROWSER
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

//CREATE Webelement email box und schreibe ich meine email adresse
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("ismailduman@gmail.com");
// creat click
        WebElement retrivePassWord= driver.findElement(By.id("form_submit"));
        retrivePassWord.click();
        String expectedUrl="http://practice.cybertekschool.com/email_send";
        String actualUrl = driver.getCurrentUrl();

        Thread.sleep(5000);
        //and match the URL
if(expectedUrl.equals(actualUrl)){
    System.out.println("PASS");
}else{
    System.out.println("FAIL");
    System.out.println("expectedUrl = " + expectedUrl);
    System.out.println("actualUrl = " + actualUrl);
}
driver.quit();
    }}
