package com.thetestingacademy.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ebay_task {

    @Description("TC#1 - Verify Ebay macmini")
    @Test
    public void ebay() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        Actions actions = new Actions(driver);
        driver.get("https://www.ebay.com/");

        WebElement search_el= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        search_el.sendKeys("Macmini");
        WebElement search_bu= driver.findElement(By.xpath("//span[@class='gh-search-button__label']"));
        actions.moveToElement(search_bu).click().build().perform();

        List<WebElement> mac_pr= driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li//span[@class='s-item__price']"));
        List<Double> priceList = new ArrayList<>();
        for (WebElement price : mac_pr) {
            String priceText = price.getText();
           // System.out.println(priceText);
            if (!priceText.contains("to")) {
                String F_price = priceText.replace("$", "").replace(",", "").trim();
                priceList.add(Double.parseDouble(F_price));
                //System.out.println(priceList);
            }
        }

        // Find and print the smallest price
        if (!priceList.isEmpty()) {
            Double minPrice = Collections.min(priceList);
            System.out.println("Smallest Price: " + minPrice);
        } else {
            System.out.println("No valid prices found.");
        }

        driver.quit();


    }
}
