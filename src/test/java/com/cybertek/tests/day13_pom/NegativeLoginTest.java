package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPasswordTest(){

      // WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        //driver.get(ConfigurationReader.get("url"));

        //String username = ConfigurationReader.get("driver_username");
        //String password = ConfigurationReader.get("driver_password");

        /*driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");*/

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("hellopassword");
        loginPage.loginBtn.click();



        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");


    }
    @Test
    public void wrongUsernameTest(){
        loginPage.usernameInput.sendKeys("mynameiskhan");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login" );
    }
}
