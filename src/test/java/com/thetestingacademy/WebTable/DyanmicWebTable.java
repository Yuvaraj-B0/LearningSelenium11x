package com.thetestingacademy.WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DyanmicWebTable {
    @Description("Open the URL")
    @Test
    public void testdynamicWebTable() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        //Rows and Column
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        //System.out.println(rows_table.get(0));
        for (int i = 0; i < rows_table.size(); i++) {
            List<WebElement> col_table = rows_table.get(i).findElements(By.tagName("td"));
            for (WebElement c : col_table) {
                System.out.println(c.getText());

            }

        }
        driver.quit();
    }
}
