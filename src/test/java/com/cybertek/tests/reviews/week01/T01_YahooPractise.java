package com.cybertek.tests.reviews.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_YahooPractise {
    public static void main(String[] args) {
        /*https://de.yahoo.com*/

        WebDriverManager.chromedriver().setup(); /*setup browser type*/

        WebDriver driver = new ChromeDriver();/*this statement open empty page*/

        //go to the page
        driver.get("https://de.yahoo.com");

        String ecpectedTitle="Yahoo";

        String actualTitle=driver.getTitle();

        System.out.println("ecpectedTitle= "+ecpectedTitle);
        System.out.println("actualTitle= "+actualTitle);

if(driver.getTitle().contains("Yahoo")){
            System.out.println("Title is ok.");
        }else
        {
            System.out.println("Title is not ok");
        }

    }
}
