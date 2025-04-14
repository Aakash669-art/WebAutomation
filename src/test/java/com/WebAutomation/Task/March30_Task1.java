package com.WebAutomation.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class March30_Task1 {

    @Description("Full flow of Katalong site")
    @Test

    public void katalongSite(){


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("=start--maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
       // driver.manage().window().maximize();

      WebElement button = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
      button.click();
      System.out.println(driver.getTitle());

        WebElement emailbox = driver.findElement(By.id("txt-username"));
        emailbox.sendKeys("John Doe");

        WebElement passwordbox = driver.findElement(By.id("txt-password"));
        passwordbox.sendKeys("ThisIsNotAPassword");

        WebElement button1 = driver.findElement(By.id("btn-login"));
        button1.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='combo_facility']")));

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Hongkong CURA Healthcare Center");

        WebElement checkBox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkBox.click();

        WebElement radioButton = driver.findElement(By.id("radio_program_medicaid"));
        radioButton.click();

        WebElement date = driver.findElement(By.id("txt_visit_date"));
        date.sendKeys("01/05/2025");

        WebElement textBox = driver.findElement(By.id("txt_comment"));
        textBox.sendKeys("abc");

        WebElement button4 = driver.findElement(By.id("btn-book-appointment"));
        button4.click();


        String result = driver.findElement(By.id("facility")).getText();
        Assert.assertEquals(result, "Hongkong CURA Healthcare Center");

        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        driver.quit();

    }
}
