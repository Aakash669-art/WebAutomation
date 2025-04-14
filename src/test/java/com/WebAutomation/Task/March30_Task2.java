package com.WebAutomation.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class March30_Task2 {


    @Description("calculate_the_Total_Money_Spent")
    @Test

    public  void Automation_Challenege_1(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.applitools.com");
        driver.manage().window().maximize();

        String first_part = "//table[@class='table table-padded']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();

        Assert.assertEquals(driver.getCurrentUrl() ,"https://demo.applitools.com/app.html");

        int rows = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr")).size();
        int colu = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr[1]/td")).size();

        for (int i =1; i<rows; i++)
        {
            for (int j=1; j<colu; j++){

                String dynamicPath = first_part+i+second_part+j+third_part;
                System.out.println(dynamicPath);
                String data = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(data);
                



            }
        }





    }
}
