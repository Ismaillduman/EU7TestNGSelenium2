package com.cybertek.tests.day7_Testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass
            public void beforDownTear(){
        System.out.println("--Before Class--");
    }
    @Test
    public void test1(){

        System.out.println("First Test Case");

    }
    @Ignore
    @Test
            public void test2(){
        System.out.println("Second Test Case");
    }
    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
@BeforeMethod
    public void setUp(){
    System.out.println("Webdriver, Opening Browser");
}
@AfterMethod
    public void tearDown(){
    System.out.println("Closing Browser, Quit");
}
@AfterClass
    public void tearDownClass(){
    System.out.println("--After Class--");
    System.out.println("Some Reporting Code Here");

}
}
