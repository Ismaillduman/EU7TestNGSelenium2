package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class positiveTest extends TestBase {
    @Test
    public void loginAsDriver(){
        LoginPage loginpage= new LoginPage();
       /* String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");


        loginpage.usernameInput.sendKeys(userName);
       loginpage. passwordInput.sendKeys(password);
        loginpage.loginBtn.click();*/

       loginpage.loginAsDriver();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager(){

       LoginPage loginpage = new LoginPage();

       loginpage.loginAsStoreManager();
    }
@Test
public void loginAsSalesmanager(){
        LoginPage loginpage = new LoginPage();

        loginpage.loginAsSalesmanager();
}

}
