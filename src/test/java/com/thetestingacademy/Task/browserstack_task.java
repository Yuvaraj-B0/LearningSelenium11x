package com.thetestingacademy.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class browserstack_task {

    @Description("TC#1 - Verify app upload")
    @Test
    public void browserstack_app() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.browserstack.com/users/sign_in");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email_login"))).sendKeys("ajithnivas8@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))).sendKeys("@Goodboy007");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign me in']"))).click();
    }



}
