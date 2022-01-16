package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class checkBoxHomeWork {

    /*Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1. Go to
http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. Login with-----Username: Tester, password: test
3. Click on check all button verify all the checkboxes are checked
4. Click on uncheck all button verify that all the checkboxes are unchecked
5. Select one of the checkbox and delete one person
6. Then verify that deleted item is no longer exists */

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement userName=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
userName.click();
        driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).click();
        driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");

        Thread.sleep(2000);
driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        WebElement checkAllButton= driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllButton.click();

        for (int i=2;i<10;i++){
            WebElement element=driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0"+i+"_OrderSelector"));
            Assert.assertTrue(element.isSelected(),"Verify is selected");
        }

        WebElement uncheckAllButton=driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckAllButton.click(); //

        for (int i=2;i<10;i++){
            WebElement element=driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0"+i+"_OrderSelector"));
            Assert.assertFalse(element.isSelected(),"Verify is unselected");
        }

        Thread.sleep(2000);
/*WebElement checkAllBox=driver.findElement(By.cssSelector("a#ctl00_MainContent_btnCheckAll"));
//driver.findElement(By.cssSelector("a#ctl00_MainContent_btnCheckAll")).click();
        checkAllBox.click();



WebElement uncheckList=driver.findElement(By.cssSelector("a#ctl00_MainContent_btnUncheckAll"));
uncheckList.click();

        Thread.sleep(3000);
/*
List<WebElement> elements=driver.findElements(By.cssSelector("//input[@type='checkbox']"));

        System.out.println(elements.size());
for(WebElement elm: elements){
    elm.click();
    Assert.assertTrue(elm.isSelected(),"verify that elm is selected");

}
 List<WebElement> elementss=driver.findElements(By.cssSelector("//input[@type='checkbox']"));
        System.out.println(elementss.size());
        for(WebElement elm: elementss){
            elm.click();
            Assert.assertTrue(elm.isSelected(),"verify that elm is not selected");

        }
        */

WebElement susan= driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
susan.click();
Thread.sleep(3000);
WebElement deleteBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
deleteBtn.click();
        Thread.sleep(3000);

WebElement deletedname=driver.findElement(By.xpath("(//*[@type='checkbox'])[5]/parent::*/following-sibling::*[1]"));
String actualName=deletedname.getText();
        Thread.sleep(3000);

Assert.assertFalse(deletedname.equals(actualName),"Name verify selected is deleted");





driver.quit();
    }

}
