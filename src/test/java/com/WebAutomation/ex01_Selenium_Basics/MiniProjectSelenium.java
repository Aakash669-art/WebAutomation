package com.WebAutomation.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.URL;
import java.sql.Driver;

public class MiniProjectSelenium {
    @Description("Verify that with invalid email, pass and check current URL after changes")
    @Test

    public  void CredentialProjectURL ()  throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("Start maximized");
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //driver.manage().window().maximize();

        WebElement button = driver.findElement(By.id("btn-make-appointment"));
        button.click();

        WebElement emailbox = driver.findElement(By.id("txt-username"));
        emailbox.sendKeys("John Doe");

        WebElement passwordbox = driver.findElement(By.id("txt-password"));
        passwordbox.sendKeys("ThisIsNotAPassword");

        WebElement button1 = driver.findElement(By.id("btn-login"));
        button1.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.quit();



    }


}
