package com.thetestingacademy.Selenium_XPATH;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium {
    @Description("Open the URL")
    @Test
    public void login_web() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement username_xath = driver.findElement(By.xpath("//input[@name = 'username']"));
        username_xath.sendKeys("admin");

        WebElement password_xpath = driver.findElement((By.xpath("//input[@name = 'password']")));
        password_xpath.sendKeys("Hacker@4321");

        WebElement submit_xpath = driver.findElement((By.xpath("//button[normalize-space()='Login']")));
        submit_xpath.click();

        Thread.sleep(2000);

      driver.quit();


    }
}
