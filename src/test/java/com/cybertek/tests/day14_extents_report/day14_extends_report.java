package com.cybertek.tests.day14_extents_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day14_extends_report {
//this klass is used for starting and building reports
    ExtentReports report;
// this used to create HTML report file
    ExtentHtmlReporter htmlReporter;
// this will define a test enables adding logs authors test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
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
    @Test
    public void test1(){
        extentLogger=report.createTest("TC123 login as driver Test");

        extentLogger.info("open chrome browser");
        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver username password");

        extentLogger.info("Click Login");

        extentLogger.info("Verify logged in");

        //pass()--> marks the test case as passed
        extentLogger.pass("TC123 is passed");


    }@AfterMethod
    public void tearDown(){
        //this when the report is actually created
        report.flush();
    }


}
