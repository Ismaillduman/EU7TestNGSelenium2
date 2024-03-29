package com.cybertek.tests.day7_Testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }
    @Test
    public void test1(){
        System.out.println("First Assertions");
        Assert.assertEquals("title","tiTle");
//buradaki hatadan sonra bu method execute edilmez.
        //diger metodu kontrol eder
        System.out.println("Second Assertions");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test2(){
        Assert.assertEquals("test","test");
        System.out.println("pass");
    }
    @Test
    public void test3(){
String expectedTitle="Cyb";
String actualTitle="Cybertek";

Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify title starts with Cyb");
    }
    @Test
    public void test4(){
       String email="mike@smith.com";
       Assert.assertTrue(email.contains("@"),"verify email contains @");
    }
    @Test
    public void test5(){
Assert.assertFalse(0>1,"verify that 0 not greater than 1");
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("ON","ONE");
    }

@AfterMethod
    public void tearDown(){
    System.out.println("Close the Browser");

}


}
