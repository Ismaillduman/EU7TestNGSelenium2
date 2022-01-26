package com.cybertek.tests.day14_extents_report;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class negativeLoginTestWithReport extends TestBase{




        @Test
        public void wrongPasswordTest() throws InterruptedException {

            extentLogger = report.createTest("wrong password test");

            LoginPage loginPage = new LoginPage();

            // WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

            //  driver.get(ConfigurationReader.get("url"));

            //String username = ConfigurationReader.get("driver_username");
            //String password = ConfigurationReader.get("driver_password");

        /*driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");*/

            Thread.sleep(3000);
            extentLogger.info("Enter UserName");
            loginPage.usernameInput.sendKeys("User1");

            extentLogger.info("Enter PassWord: hellopassword");
            loginPage.passwordInput.sendKeys("hellopassword");

            extentLogger.info("click login button");
            loginPage.loginBtn.click();

            extentLogger.info("verify page url");
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

            extentLogger.pass("Wrong Password test is PASSED");


        }
        @Test
        public void wrongUsernameTest(){

            extentLogger = report.createTest("wrong username test");

            LoginPage loginPage = new LoginPage();
            extentLogger.info("Enter username: 3idiot");
            loginPage.usernameInput.sendKeys("3idiot");

            extentLogger.info("Enter password: UserUser123");
            loginPage.passwordInput.sendKeys("UserUser123");

            extentLogger.info("Enter Login Button");
            loginPage.loginBtn.click();

            extentLogger.info("Verify url");
            Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login/QEW" );

            extentLogger.pass("PASSED");

        }
    }


