package com.WebAutomation.ex02_Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class MiniProject3 {
@Test
    public  void miniProject(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.name("firstname"));
        inputBox.sendKeys("Aakash");

     WebElement inputBoxP = driver.findElement(By.name("lastname"));
    inputBoxP.sendKeys("Kansal");

    WebElement radioButton = driver.findElement(By.id("sex-0"));
    radioButton.click();

    WebElement checkBox = driver.findElement(By.id("profession-0"));
    checkBox.click();

    }
}
