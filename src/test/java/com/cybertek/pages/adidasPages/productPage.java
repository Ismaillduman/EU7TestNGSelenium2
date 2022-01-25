package com.cybertek.pages.adidasPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends BasePageForAdidas {

    @FindBy(tagName = "h2")
    public WebElement productName;

    @FindBy(tagName = "h3")
    public WebElement priceElement;
    @FindBy(xpath = "//div[@id='more-information']/p")
    public WebElement productDescription;


}
