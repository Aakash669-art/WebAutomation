package RelativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;

import java.time.Duration;

import static com.WebAutomation.WaitHelper.waitHelper.waitJVM;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class RX_01 {

    @Test

    public void test_js() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Stay signed out']")));
       WebElement stay =  driver.findElement(By.xpath("//button[.='Stay signed out']"));

        Actions action = new Actions(driver);
        action.moveToElement(stay).click().build().perform();
        driver.findElement(By.id("//textarea[@id=\"APjFqb\"]")).sendKeys("mandeep bdhva");

//        WebElement span = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
//        driver.findElement(with(By.id("exp-1")).toRightOf(span)).click();
    }

}
