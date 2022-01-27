package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {
    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
@Test
    public void contactDetailsTest(){
    extentLogger = report.createTest("Contact Info Verification");
    LoginPage loginPage = new LoginPage();

    String username = ConfigurationReader.get("salesmanager-username");
    String password =ConfigurationReader.get("salesmanager-password");
    extentLogger.info("username: "+username);
    extentLogger.info("password: "+password);
    extentLogger.info("Login as a Sales Manager");
    loginPage.loginAsSalesmanager();

    extentLogger.info("Navigate to --. customers --> contacts");

    new DashboardPage().navigateToModule("Customers", "Contacts");


    ContactPage contactPage = new ContactPage();
    contactPage.waitUntilLoaderScreenDisappear();
    extentLogger.info("Click on mbrackstone9@example.com");
    contactPage.getContactEmail("mbrackstone9@example.com").click();

    ContactInfoPage contactInfoPage = new ContactInfoPage();

    String expectedFullNAme= "Mariam Brackstone";
    String expectedEmail = "mbrackstone9@example.com";
    String expectedPhoneNumber= "+18982323434";

    String actualFullname= contactInfoPage.fullName.getText();
    String actualEmail = contactInfoPage.email.getText();
    String actualPhoneNumber= contactInfoPage.phoneNumber.getText();

    extentLogger.info("verify full name is"+ expectedFullNAme);
    Assert.assertEquals(actualFullname, expectedFullNAme, "Verify full name");
    extentLogger.info("verify expected email is "+ expectedEmail);
    Assert.assertEquals(actualEmail, expectedEmail," verify email");
    extentLogger.info("verify expected phone numer ist "+ expectedPhoneNumber);
    Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber," Verify phone number");

    extentLogger.pass("PASSED");








}

}
