package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/index.html#");

        WebElement laptopsCatogorie= driver.findElement(By.linkText("Laptops"));
        laptopsCatogorie.click();
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Sony vaio i7")).click();
        Thread.sleep(3000);
        int expectedPrice=790;

        String priceText=driver.findElement(By.tagName("h3")).getText();

        String [] Arr=priceText.split(" ");
        System.out.println(Arr[0]);


    }
}
