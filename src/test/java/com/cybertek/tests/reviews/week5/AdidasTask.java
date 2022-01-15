package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdidasTask {
 /*
 Adidas Company QA Test
You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"
HW: finish the task by returning deleted product price
capture expectedPurchaseAmount dynamically
Do the rest of the task, use Faker class for the form
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");

    }

    @AfterMethod
    public void closeTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void navigateTo(String str) {
        driver.findElement(By.partialLinkText(str)).click();
    }

    public int productAdder(String category, String product) {






return 0;
    }
@Test
    public void Test(){

}

}