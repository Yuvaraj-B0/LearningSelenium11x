package com.thetestingacademy.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class applitools_task {

    @Description("TC#1 - Verify Total Amount of Money Spent")
    @Test
    public void applitools() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.applitools.com/");
        String username = "Admin";
        String password = "Password@123";
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//a[@id='log-in']")).click();

        // //table[@class='table table-padded']/tbody/tr[1]/td[5]
        String first_part = "//table[@class='table table-padded']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr[1]/td")).size();

        double amount;
        double total = 0.0;
//        System.out.println(row);
//        System.out.println(col);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (j==5){
                    String dyanmic_path = first_part + i + second_part + j + third_part;
                    // System.out.println(dyanmic_path);
                    String amountText = driver.findElement(By.xpath(dyanmic_path)).getText();
                    amountText = amountText.replace(" ","").replace(",", "")
                            .replace("$", "").replace("USD","").trim();
                   // System.out.println(amountText);
                    amount=Double.parseDouble(amountText);
                    total += amount;


                }

            }
        }
      //  System.out.println(total);
        Assert.assertEquals(total,1996.22,"Assertion verified");


    }
}


