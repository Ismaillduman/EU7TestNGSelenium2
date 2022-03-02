package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
@DataProvider
    public Object[][] testData(){
    String [][] data ={
    {"Person of interest","10"},
    {"scherlock","9"},
    {"Breaking Bad","9"},
    {"the office","8"},
    {"Friends","7"},
    {"westworld","10"},
    {"gotham","9"}
    };
    return data;
}
@Test(dataProvider = "testData")
    public void test1(String TVshow, String rating){

    System.out.println("tv show"+TVshow+" has rating"+rating);
}


}
