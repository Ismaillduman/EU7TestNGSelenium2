package com.cybertek.tests.day_2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);
        //getting the Title with Selenium
        //shortcut for creating variable
        //option or ALT Enter
        //get.Title of the Page
        String title = driver.getTitle();
        System.out.println("title = " + title);

        // getCurrentUrl---> get the Url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }

}
