package RelativeXpath;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;



import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

import static com.WebAutomation.WaitHelper.waitHelper.waitJVM;

public class RX_03 {

    @Test


    public void test_js() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        search.sendKeys("China" + Keys.ENTER);

        waitJVM(5000);

        List<WebElement> location = driver.findElements(By.cssSelector("div.location-name > p"));
        for(WebElement locations : location){
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(locations)).getText();
            String aqi = driver.findElement(with(By.tagName("p")).toRightOf(locations)).getText();
            System.out.println("| +" + rank + " | " +locations.getText() + " | " + aqi + " | ");
        }
    }
}