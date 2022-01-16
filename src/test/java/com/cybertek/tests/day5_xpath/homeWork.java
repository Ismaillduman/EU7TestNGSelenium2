package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.de/ref=nav_logo");

        WebElement inputSearchBox=driver.findElement(By.id("twotabsearchtextbox"));
        inputSearchBox.sendKeys("Selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();
Thread.sleep(3000);
        String getText=driver.findElement(By.xpath("//span[contains(text(),'Vorschlägen')]")).getText();

        String[] arr=getText.split(" ");
        System.out.println("Search Result= "+arr[0]);

        String expectedText="1-48 von 716 Ergebnissen oder Vorschlägen für";
        driver.quit();
if(expectedText.equals(getText)){
    System.out.println("PASS");
}else{
    System.out.println("FAILD");
    System.out.println("expectedText = " + expectedText);
    System.out.println("getText = " + getText);
}
    }
}
