package com.cybertek.tests.day7_Testng;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class practise {
    public WebDriver driver;// declare your variable/object globally and use it at every method
    // annotations are there to effect your test flow
/*bir selenium Automation aiatemi kurarken before ve after methodlariyla baslamak
organizasyon acisindan kolaylik saglar ayrica testcase'in her bir adimi icin de bir
yeni test anotation  kullanilabilir. Boylece bir butunu prcalara bolmus ve
hatalari daha kolay ayiklamaya da faydasi olabilir.
*/
@BeforeMethod
    public void openPage(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        //login to Webpage
        WebElement usernameBox= driver.findElement(By.id("ctl00_MainContent_username"));
        usernameBox.sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
}
@AfterMethod
    public void closeBrowser(){
    driver.quit();

}
@Test(priority = 1)
    public void checkBoxAll(){

    WebElement checkAllBoxx=driver.findElement(By.xpath("//a[@id=\"ctl00_MainContent_btnCheckAll\"]"));
    //WebElement checkAllBoxx=driver.findElement(By.linkText("Check All"));
    checkAllBoxx.click();
/*
    Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
    Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
    Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected();
    Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).isSelected();
*/
    for(int i=1;i<=8;i++){
String rowCheckBoxLocator="(//input[@type='checkbox'])["+i+"]";
WebElement rowCheckBox=driver.findElement(By.xpath(rowCheckBoxLocator));
        Assert.assertTrue(rowCheckBox.isSelected(),"The CheckBox is not selected ");
    }
    WebElement uncheckAllButton=driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
    uncheckAllButton.click();
    for(int i=1;i<=8;i++){

String rowCheckBoxLocator="(//input[@type='checkbox'])["+i+"]";
WebElement rowCheckBox=driver.findElement(By.xpath(rowCheckBoxLocator));
        Assert.assertFalse(rowCheckBox.isSelected(),"The CheckBox is Still selected ");
    }
}
@Test (priority = 2)
    public void deletePerson(){
    String name="Charles Dodgeson";

    String locatorCheckBoxPerson="//*[contains(text(),'"+name+"')]/preceding-sibling::*/input";
    WebElement checkBoxPerson=driver.findElement(By.xpath(locatorCheckBoxPerson));
    checkBoxPerson.click();

    WebElement deleteButton=driver.findElement(By.id("ctl00_MainContent_btnDelete"));
    deleteButton.click();

    ArrayList<String> names=new ArrayList<>();

    for(int i=1;i<=7;i++){

    String eachNameLocator="(//input[@type='checkbox'])["+i+"]/../../td[2]";
    WebElement eachNameElement= driver.findElement(By.xpath(eachNameLocator));
    String eachName=eachNameElement.getText();
    names.add(eachName);


    }
    System.out.println("names= "+names);
    Assert.assertFalse(names.contains(name),"The Name is still there. could not delete");
}


}
