package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHTest {
    /* Go to Ebay
    search Selenium
    click on search button
    print number of results
    verify title contains Selenium*/

    public static void main(String[] args)  {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
       // ctr+D WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        //WebElement searchInputBox= driver.findElement(By.id("gh-ac"));
        //WebElement searchInputBox= driver.findElement(By.name("_nkw"));
        WebElement searchInputBox= driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        //WebElement searchInputBox= driver.findElement(By.className("gh-tb ui-autocomplete-input"));
        String expectedSearchItem="selenium";
        searchInputBox.sendKeys(expectedSearchItem);
//lazy way
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResultElement=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
String searchResultText=searchResultElement.getText();

String [] arr=searchResultText.split(" ");
        System.out.println("Numbers of search result"+arr[0]);

        driver.close();
    }
}
