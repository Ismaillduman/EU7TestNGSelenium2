package com.cybertek.tests.day11_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
Thread.sleep(2000);
    //driver.quit();
    }
@Test
    public void printTable(){
    WebElement table1= driver.findElement(By.id("table1"));
    System.out.println(table1.getText());

    Assert.assertTrue(table1.getText().contains("http://www.jsmith.com"));

}
@Test
    public void getAllHeaders(){
        //how many columns we have?
 ArrayList<WebElement> headers = (ArrayList<WebElement>) driver.findElements(By.xpath("//table[@id='table1']//th"));

    System.out.println(headers.size());

    for (WebElement header : headers) {

        System.out.println(header.getText());
    }
List<WebElement> allRowsWithHeader= driver.findElements(By.xpath("//table[@id='table1']//tr"));
    System.out.println(allRowsWithHeader.size());

    List<WebElement> allRowsWithOutHeader= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
    System.out.println(allRowsWithOutHeader.size());

   List<WebElement> numRows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
   for (int i=1;i<=numRows.size()-1;i++) {
       WebElement Row= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));

   }


    WebElement row2= driver.findElement(By.xpath("//tbody/tr[2]"));
    System.out.println(row2.getText());
}
@Test
    public void getRow(){
    //print the second row information
    String xpath = "//table[@id='table1']//tr[2]";
WebElement Row2 = driver.findElement(By.xpath(xpath));
    System.out.println(Row2.getText());

    //get all rows dynamically
    //1.find number of rows

  /* List<WebElement> rowsNum= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
    for (WebElement element : rowsNum) {
        System.out.println(element.getText());
    }*/
    List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
    System.out.println(numRows.size());
    //2.iterate one by one
    for (int i = 1; i <= numRows.size(); i++) {
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
        System.out.println(i+"-"+row.getText());
    }


}
@Test
    public void getAllCellInOneRow1(){
        List<WebElement> AllCellInOneRow= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
/*for(int i = 1;i<=4;i++){

    for(int j=1;j<=6; j++){
        String cellXPath= "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";

        WebElement cell=driver.findElement(By.xpath(cellXPath));
        System.out.println(cell.getText());
    }
}*/

    AllCellInOneRow.forEach(n-> System.out.println(n.getText()+"|")); //for each Method oop concepts

}
    @Test
    public void getAllCellInOneRow(){
        ArrayList<WebElement> allCellsInOneRow = (ArrayList<WebElement>) driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));

        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
}
@Test
public void getASingleCellByIndex(){
        WebElement SingleCell = driver.findElement(By.xpath("//table[@id='table1']//tr[3]/td[4]"));
    System.out.println("SingleCell.getText() = " + SingleCell.getText());
}

@Test
    public void printAllCellsByIndex(){
        int rowNumber= getNumberOfRows();
        int colNumber= getNumberOfColumn();

        for(int i = 1;i<=rowNumber;i++){
            for(int j = 1; j<= colNumber; j ++){

                WebElement AllCellsByIndex = driver.findElement(By.xpath("//table[@id='table1']//tr["+i+"]//td["+j+"]"));
                String cellXpath ="//table[@id='table1']//tr["+i+"]//td["+j+"]";
                System.out.println("cellXpath = " + cellXpath);
                System.out.println(AllCellsByIndex.getText());
            }
        }




}

    private int getNumberOfColumn() {
List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//tr/th"));

return headers.size();


    }

    private int getNumberOfRows() {

        List<WebElement> allRowsWithOutHeaders= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithOutHeaders.size();

    }
    @Test
    public void getCellRelationsToAnotherCellInSameRow(){
        WebElement RelationsAnotherCell= driver.findElement(By.xpath("//td[.='Jason']/../td[5]"));
        System.out.println(RelationsAnotherCell.getText());

    }

}