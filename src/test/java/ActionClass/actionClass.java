package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class actionClass {

    @Test
    public  void actionClass1(){

        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://awesomeqa.com/practice.html");
        webDriver.manage().window().maximize();

        WebElement firstname = webDriver.findElement(By.name("firstname"));
        Actions action = new Actions(webDriver);
        action.keyDown(Keys.SHIFT).sendKeys(firstname , "Aakash").keyUp(Keys.SHIFT).build().perform();
      



    }
}
