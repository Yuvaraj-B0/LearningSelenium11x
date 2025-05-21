package com.thetestingacademy.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class Katalon_task {



    @Description("TC#1 - Verify make_appointmen of katalon app")
    @Test
    public void katalon_make_appointment() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement make_appointment= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        make_appointment.click();
        Thread.sleep(3000);

        String user_name=driver.findElement(By.xpath("//input[@value='John Doe']")).getAttribute("value");
        //System.out.println(user_name);
        String password=driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']")).getAttribute("value");

        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys(user_name);
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys(password);
        //Login process
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        Thread.sleep(3000);
        //make_appointment process
        WebElement drop_down= driver.findElement(By.xpath("//select[@id='combo_facility']"));
        Select select = new Select(drop_down);
        select.selectByContainsVisibleText("Hongkong CURA Healthcare Center");
        //check box
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        //Radio button
            List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
            for (WebElement e: radio){
                //System.out.println(e.getAttribute("value"));
                if(e.getAttribute("value").contains("Medicaid")){
                    e.click();
                }
            }
         //date
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("22/05/2025");
       //Comments
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("qwertyuiop");
        //make_appointmen button
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        //Assertion
        Assertion assertion = new Assertion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-12 text-center']/h2")));
        String get_string=driver.findElement(By.xpath("//div[@class='col-xs-12 text-center']/h2")).getText();
        assertion.assertEquals(get_string,"Appointment Confirmation");
        driver.quit();

    }
}
