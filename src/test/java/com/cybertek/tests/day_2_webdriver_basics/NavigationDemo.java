package com.cybertek.tests.day_2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");

//navigate another website with different selenium method
driver.navigate().to("https://twitter.com/home?lang=de");

// wait 3 second here then move on
   Thread.sleep(3000);


//goes back to previous page
    driver.navigate().back();

    Thread.sleep(2000);

    //goes back to back
    driver.navigate().forward();

    driver.navigate().refresh();
    }
}
