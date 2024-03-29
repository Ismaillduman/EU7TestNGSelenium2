package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

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
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
// 1. locate your dropDown just like any other webelement with unique locator

    WebElement dropDownElement= driver.findElement(By.id("state"));
    //2. create Select object by passing that element as a constructor
    Select stateDropDown = new Select(dropDownElement);
//getOptions ---> return all the available options from the dropdown
    List<WebElement> options = stateDropDown.getOptions();
    System.out.println("options.size() = " + options.size());

    //print options one by one
    for (WebElement option : options) {
        System.out.println(option.getText());
    }

}

@Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement= driver.findElement(By.id("state"));

        Select stateDropdown= new Select(dropDownElement);

        String expectedOption ="Select a State";
   String actualOption = stateDropdown.getFirstSelectedOption().getText();

    Assert.assertEquals(actualOption,expectedOption,"verify your selection");

   //how to select options from dropdown
    //1.select using visible text
Thread.sleep(2000);
    stateDropdown.selectByVisibleText("Virginia");

expectedOption="Virginia";
actualOption=stateDropdown.getFirstSelectedOption().getText();
Assert.assertEquals(expectedOption,actualOption,"verify the selection");
    
//2 select using the index
Thread.sleep(2000);
   stateDropdown.selectByIndex(51);

   expectedOption="Wyoming";
   actualOption=stateDropdown.getFirstSelectedOption().getText();
   Assert.assertEquals(actualOption,expectedOption,"verify first selection");

   //3 SELECT BY VALUE
    Thread.sleep(2000);
    stateDropdown.selectByValue("TX");
    expectedOption="Texas";
    actualOption=stateDropdown.getFirstSelectedOption().getText();
    Assert.assertEquals(expectedOption,actualOption,"verify first selection");


}
}
