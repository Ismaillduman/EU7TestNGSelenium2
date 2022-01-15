package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void oneImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(img1).perform();

        WebElement text1 = driver.findElement(By.xpath("//h5[.=\"name: user1\"]"));

        Assert.assertTrue(text1.isDisplayed(), "verify text 1 is displayed");


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        for(int i=1;i<=3;i++){
            String xpathImage="(//img)["+i+"]";
            WebElement img= driver.findElement(By.xpath(xpathImage));
            System.out.println(xpathImage);

            Actions actions= new Actions(driver);
            Thread.sleep(2000);

            actions.moveToElement(img).perform();

            String textPath= "//h5[.='name: user"+i+"']";
            WebElement text1= driver.findElement(By.xpath(textPath));
            System.out.println(textPath);
            Assert.assertTrue(text1.isDisplayed(), "verify user "+i+" is displayed");


        }




    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(2000);
driver.manage().window().maximize();
        Thread.sleep(2000);
Actions actions = new Actions(driver);
WebElement source = driver.findElement(By.id("draggable"));
WebElement target = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);
driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        Thread.sleep(2000);
actions.dragAndDrop(source,target).perform();




    }
    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }
}