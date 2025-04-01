package com.WebAutomation.ex02_Selenium_Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts2 {


    @Test

    public void alerts (){


        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement jsalert3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsalert3.click();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("abc");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: abc");




    }
}
