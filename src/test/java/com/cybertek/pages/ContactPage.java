package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage{

//td[@data-column-label='Email'][contains(text(),'mbrackstone9@example.com')]
    public WebElement getContactEmail(String email){
        String xpath="//td[@data-column-label='Email'][contains(text(),'"+email+"')]";
        return Driver.get().findElement(By.xpath(xpath));

    }
}
