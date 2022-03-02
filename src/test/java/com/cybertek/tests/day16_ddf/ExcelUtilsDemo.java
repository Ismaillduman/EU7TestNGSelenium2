package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata (1).xlsx", "QA3-short");

        //how many rows in the sheet

        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        // how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());
        // get all columnsName
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());
        // get all data in list of maps
        List<Map<String , String>> dataList=  qa3short.getDataList();

        for (Map<String, String> onerow : dataList) {
            //System.out.println(onerow);
        }
// get nona as value
        System.out.println(dataList.get(2).get("firstname"));
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));

        String [][] dataArray = qa3short.getDataArray();

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));


    }
}
