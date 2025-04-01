package com.WebAutomation.ex02_Selenium_Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    @Test
    public  void  alerts() {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

//        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick = \"jsAlert()\"]"));
//        jsAlert.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//        String result = driver.findElement(By.id("result")).getText();
//
//        Assert.assertEquals(result, "You successfully clicked an alert");

        WebElement jsalert2 = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
         jsalert2.click();

        WebDriverWait wait1= new WebDriverWait(driver , Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
       alert.accept();
         String result = driver.findElement(By.id("result")).getText();

         Assert.assertEquals(result,"You clicked: Ok");
   }
    }