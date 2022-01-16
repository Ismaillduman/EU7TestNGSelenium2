package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
         /*
    Verify confirmation message
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an
external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!' confirmation_message
     */
       WebDriver driver=WebDriverFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/forgot_password");
       WebElement emailInputBox= driver.findElement(By.name("email"));
       String expectedEmail="ismailduman@web.de";
      emailInputBox.sendKeys(expectedEmail);
      
      String actualEmail= emailInputBox.getAttribute("value");
      if(expectedEmail.equals(actualEmail)){
          System.out.println("PASS");
      }else{
          System.out.println("FAIL");
          System.out.println("expectedEmail = " + expectedEmail);
          System.out.println("actualEmail = " + actualEmail);
      }
WebElement retrivePassWord=driver.findElement(By.id("form_submit"));
     retrivePassWord.click();
     WebElement confirmationMessage=driver.findElement(By.name("confirmation_message"));
     String expectedMessage="Your e-mail's been sent!";
       String actualMessage= confirmationMessage.getText();

       if(actualMessage.equals(expectedMessage)){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
           System.out.println("actualMessage = " + actualMessage);
           System.out.println("expectedMessage = " + expectedMessage);
       }
       Thread.sleep(300);
       driver.quit();
    }
}
