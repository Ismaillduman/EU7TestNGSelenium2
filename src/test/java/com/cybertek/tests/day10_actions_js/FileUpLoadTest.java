package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpLoadTest {
  WebDriver driver;

  @BeforeMethod
    public void setUp(){
      driver= WebDriverFactory.getDriver("chrome");

  }
@AfterMethod
    public void tearDown() throws InterruptedException {
      Thread.sleep(2000);
      driver.quit();
}
@Test
    public void test1() {
    driver.get("http://practice.cybertekschool.com/upload");

    WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

    chooseFile.sendKeys("C:\\Users\\mustermann\\Desktop\\file Uploader.txt");
    driver.findElement(By.cssSelector("#file-submit")).click();

    String actualFileName = driver.findElement(By.cssSelector("#uploaded-files")).getText();

    Assert.assertEquals(actualFileName, "file Uploader.txt");


}
@Test
    public void test2(){
    driver.get("http://practice.cybertekschool.com/upload");

    WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));

    //sending file with sendKeys method

String projectPath= System.getProperty("user.dir");
String filePath= "src/test/resources/upLoadtext.txt";
String fullPath = projectPath+"/"+filePath;

chooseFile.sendKeys(fullPath);
    //clicking upload button
    driver.findElement(By.cssSelector("#file-submit")).click();
    //getting the file name from browser

    String actualFileName = driver.findElement(By.cssSelector("#uploaded-files")).getText();

    Assert.assertEquals(actualFileName, "upLoadtext.txt");


      }

}
