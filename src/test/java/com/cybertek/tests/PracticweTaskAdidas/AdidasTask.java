package com.cybertek.tests.PracticweTaskAdidas;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    int expectedPurchaseAmount = 0;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    public void navigateTo(String str){
        driver.findElement(By.partialLinkText(str)).click();
    }


    public int productAdd(String category, String product) throws InterruptedException {

        navigateTo(category);
        Thread.sleep(2000);
        navigateTo(product);

    WebDriverWait wait = new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));

    WebElement price = driver.findElement(By.tagName("h3"));
    String Wholeprice= price.getText();
    String[] arr = Wholeprice.split(" ");
    int listPrice = Integer.parseInt(arr[0].substring(1));

navigateTo("Add to cart");
        wait.until(ExpectedConditions.alertIsPresent());
    Alert alert=driver.switchTo().alert();
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Place Order")));
    alert.accept();
    navigateTo("Home");
    return listPrice;

}

    public int productRemover(String product) throws InterruptedException {
        // locator //tr[contains(.,'Sony vaio i5')]/td[4]/a
        navigateTo("Cart");
        WebElement deletButton = driver.findElement(By.xpath("//tr[contains(.,'"+product+"')]/td[4]/a"));
        deletButton.click();
        Thread.sleep(3000);
        return 0;}
@Test
    public void Test() throws InterruptedException {

        expectedPurchaseAmount+= productAdd("Laptops", "Sony vaio i5");
        expectedPurchaseAmount+=productAdd("Laptops", "Dell i7 8gb");

    System.out.println("expectedPurchaseAmount= "+expectedPurchaseAmount);

}


}
