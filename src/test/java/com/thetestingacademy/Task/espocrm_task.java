package com.thetestingacademy.Task;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class espocrm_task {

    @Description("TC#1 - Verify espocrm")
    @Test
    public void espocrm() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        Actions actions = new Actions(driver);

       Faker faker  = new Faker();

        driver.get("https://demo.us.espocrm.com/?l=en_US#");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-login']"))).click();

        Thread.sleep(5000);


        WebElement leads = driver.findElement(By.xpath("//li[@data-name='Lead']"));
        actions.moveToElement(leads).click().build().perform();

        Thread.sleep(2000);

        WebElement createlead = driver.findElement(By.xpath("//a[@data-action='create']"));
        createlead.click();

        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='col-sm-3 col-xs-3']//input[@type='text'][@autocomplete='new-password']"));
        dropdown.isDisplayed();
        dropdown.click();

        WebElement select = driver.findElement(By.xpath("//div[text()='Mr.']"));
        select.isDisplayed();
        select.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@data-name='firstName']"));
        String f_name=faker.name().firstName();
        firstName.sendKeys(f_name);
        WebElement lastName = driver.findElement(By.xpath("//input[@data-name='lastName']"));
        String l_name=faker.name().lastName();
        lastName.sendKeys(l_name);

        WebElement phonenumber = driver.findElement(By.xpath("//div[text()='Mobile']"));
        phonenumber.isDisplayed();

        WebElement phonenumber_drop = driver.findElement(By.xpath("//input[@autocomplete='espo-phoneNumber']"));
        phonenumber_drop.sendKeys("1234554321");
        WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
        save.click();

        Thread.sleep(2000);

        WebElement leadLink = driver.findElement(By.xpath("//a[text()='Leads']"));
        leadLink.click();
        WebElement searchBox= driver.findElement(By.xpath("//input[@data-name='textFilter']"));
        searchBox.sendKeys(f_name+" "+l_name+ Keys.ENTER);
        Thread.sleep(2000);

        WebElement Get_name = driver.findElement(By.xpath("//div[@class='list-container']/div[3]/table/tbody/tr/td[2]"));
        String name = Get_name.getText();
        Assert.assertEquals(name,f_name+" "+l_name);

    }

}
