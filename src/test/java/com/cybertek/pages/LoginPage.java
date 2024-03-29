package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {//constructor
       PageFactory.initElements(Driver.get(), this);

    }

    //driver.findElement(By.id("prependedInput"));

    @FindAll({
            @FindBy(id="prependedInput"),
            @FindBy(name="_username")
    })
    public WebElement usernameInput;

    @FindBy(id= "prependedInput2")
    public WebElement passwordInput;


    //driver.findElement(By.id("_submit"));
    @FindBy(id="_submit")
    public WebElement loginBtn;


    public void login (String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

public void loginAsDriver(){
      String userName = ConfigurationReader.get("driver_username");
      String password = ConfigurationReader.get("driver_password");


      usernameInput.sendKeys(userName);
      passwordInput.sendKeys(password);
      loginBtn.click();
}

public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemaneger_username");
        String password = ConfigurationReader.get("storemaneger_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
}

public void loginAsSalesmanager(){

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
}

}
