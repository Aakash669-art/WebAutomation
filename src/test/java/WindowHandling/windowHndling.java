package WindowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHndling {

    @Test

    public  void windowHandling(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String Parent = driver.getWindowHandle();
        System.out.println(Parent);

        driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();

        Set<String> windowsHandle = driver.getWindowHandles();
        System.out.println(windowsHandle);

        for (String handle : windowsHandle){
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window")){
                System.out.println("Test case is passed");
            }
            driver.switchTo().window(Parent);
        }


}}
