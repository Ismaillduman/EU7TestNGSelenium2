package com.cybertek.tests.day_2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallDriverFactory {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://twitter.com/home?lang=de");

        String title = driver.getTitle();
        System.out.println("title = " + title);

    }
}
