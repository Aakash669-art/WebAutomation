package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class fileUpload {

    @Test

    public  void testUploadFile(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        WebElement upload = driver.findElement(By.id("fileToUpload"));
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        //C:\Users\aakash.k\IdeaProjects\WebAutomation

        upload.sendKeys(workingDir +"/src/test/java/FileUpload/TestData.text");
        driver.findElement(By.name("submit")).click();

}}
