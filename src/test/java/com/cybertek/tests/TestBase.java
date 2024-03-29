package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected   WebDriverWait wait;
    //this klass is used for starting and building reports
    protected static ExtentReports report;
    // this used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    // this will define a test enables adding logs authors test steps
    protected static ExtentTest extentLogger;
    @BeforeTest
    public void testSetUp(){

        //initialize the class
        report = new ExtentReports();

        // create a report path

        String projectPath= System.getProperty("user.dir");
        String path= projectPath + "/test-output/report.html";

        htmlReporter = new ExtentHtmlReporter(path);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack smoke test");

        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS","os.name");


    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        //Thread.sleep(3000);
        driver = Driver.get();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //RECORD THE NAME of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //add your screenshot and put inside the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }
    @AfterTest
    public void tearDownTest(){
        //this when the report is actually created
        report.flush();
    }

}
