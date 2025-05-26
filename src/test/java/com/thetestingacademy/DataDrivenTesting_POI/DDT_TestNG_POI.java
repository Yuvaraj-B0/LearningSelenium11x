package com.thetestingacademy.DataDrivenTesting_POI;

import com.thetestingacademy.CommonToAll;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT_TestNG_POI extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email,String password) {
        System.out.println(email + " - "+ password);


    }

    @DataProvider
    public Object[][] getData(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");

    }


}