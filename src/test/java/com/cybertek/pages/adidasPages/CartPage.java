package com.cybertek.pages.adidasPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.text.Element;

public class CartPage extends BasePageForAdidas {
    WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement placeOrder;

    @FindBy(id = "name")
    public WebElement fakeName;

    @FindBy(id="country")
    public WebElement country;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="card")
    public WebElement card;

    @FindBy(id="month")
    public WebElement month;

    @FindBy(id="year")
    public WebElement year;
    //@FindBy(xpath ="//p[contains(.,'Card Number')]")
    @FindBy(xpath ="//p[contains(.,'Id')]")
    public WebElement valid;

    @FindBy(xpath = "//button[@onclick= 'purchaseOrder()']")
    public WebElement purchase;

    public String fakename1;

    @FindBy(xpath = "//p[@style='display: block;']")
    public Element cheque;

    public void fillForm(){
        Faker faker = new Faker();

        fakeName.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys(""+faker.number().numberBetween(1,12));
        year.sendKeys(""+faker.number().numberBetween(2022,2025));

        fakename1=   fakeName.getText();










        /*@Test
public void test_array_pass()
{
  List<String> actual = Arrays.asList("fee", "fi", "foe");
  List<String> expected = Arrays.asList("fee", "fi", "foe");

  assertThat(actual, is(expected));
  assertThat(actual, is(not(expected)));
}*/



    }
   /// public int getActualPrice(){

  //String cheque = driver.findElement(By.xpath("//p[@style='display: block;']")).getText();
     // Element price = cheque.getElement(2);
       // return Integer.parseInt(price.trim());

   // }
    public void verifyPrice(int expectedPrice, int actualPrice){
        Assert.assertEquals(actualPrice,expectedPrice, "Price has failed to verify");
    }

}
