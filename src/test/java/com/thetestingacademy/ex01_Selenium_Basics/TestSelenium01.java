package com.thetestingacademy.ex01_Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void test_VerifyVWOLogin(){
//        FirefoxDriver driver = new FirefoxDriver();
//        driver.get("https://app.vwo.com");
//        driver.quit();
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("admin@gmail.com");
        driver.quit();

    }
}
